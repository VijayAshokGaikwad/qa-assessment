package com.example.demo.controllers;

import com.example.demo.exceptions.GroceryNotAvailableException;
import com.example.demo.model.entity.ShoppingOrder;
import com.example.demo.model.request.OrderItemRequest;
import com.example.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity addNewOrder(@RequestBody List<OrderItemRequest> orderItems) {
        Long orderId = null;
        try {
            orderId = orderService.addNewOrder(orderItems);
            return ResponseEntity.ok(orderId);
        } catch (GroceryNotAvailableException e) {
            e.getLocalizedMessage();
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/orders")
    public ResponseEntity getAllOrders() {
        List<ShoppingOrder> allShoppingOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allShoppingOrders);
    }
}
