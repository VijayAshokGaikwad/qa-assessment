package com.example.demo.service;

import com.example.demo.exceptions.GroceryNotAvailableException;
import com.example.demo.model.builders.OrderItemBuilder;
import com.example.demo.model.entity.Grocery;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.ShoppingOrder;
import com.example.demo.model.request.OrderItemRequest;
import com.example.demo.model.response.OrderItemResponse;
import com.example.demo.model.response.ShoppingOrderResponse;
import com.example.demo.repository.GroceryRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final GroceryRepository groceryRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, GroceryRepository groceryRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.groceryRepository = groceryRepository;
    }

    @Transactional
    public Long addNewOrder(List<OrderItemRequest> orderItemRequests) throws GroceryNotAvailableException  {
        ShoppingOrder order = new ShoppingOrder();
        orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest item : orderItemRequests) {
            OrderItem build = new OrderItemBuilder()
                    .withGrocery(getValidGroceryItem(item))
                    .withQuantity(item.getQuantity())
                    .withShoppingOrder(order)
                    .build();
            orderItems.add(build);
        }

        orderItemRepository.saveAll(orderItems);

        logger.info("Order placed successfully. Reference id" + order.getId());
        return order.getId();
    }

    private Grocery getValidGroceryItem(OrderItemRequest item) throws GroceryNotAvailableException {
        Optional<Grocery> listedGroceryItems = groceryRepository.findById(item.getGroceryId());

        if (listedGroceryItems.isEmpty()) {
            throw new GroceryNotAvailableException("Grocery item " + item.getGroceryId() + " not available");
        }

        if (listedGroceryItems.get().getAvailableQuantity() < item.getQuantity()) {
            throw new GroceryNotAvailableException("Grocery item " + item.getGroceryId() + " not enough in quantity");
        }

        return listedGroceryItems.get();

    }

    public List<ShoppingOrderResponse> getAllOrders() {
        List<ShoppingOrder> orders = orderRepository.findAll();

        return orders.stream().map(this::extractOrderItems).collect(Collectors.toList());
    }

    private ShoppingOrderResponse extractOrderItems(ShoppingOrder order) {
        List<OrderItem> orderItems = orderItemRepository.findAllWhereQuantityIsGreaterThanZero(order);

        List<OrderItemResponse> orderItemsResponse = orderItems.stream().map((orderItem) -> {
            return new OrderItemResponse(orderItem.getId(), orderItem.getGroceryId().getId(), orderItem.getQuantity());
        }).collect(Collectors.toList());

        return new ShoppingOrderResponse(order.getId(), orderItemsResponse);
    }
}
