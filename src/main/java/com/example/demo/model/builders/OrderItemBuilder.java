package com.example.demo.model.builders;

import com.example.demo.model.entity.Grocery;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.ShoppingOrder;

public class OrderItemBuilder {
    private Long id;
    private ShoppingOrder shoppingOrder;
    private Grocery grocery;
    private int quantity;

    public OrderItemBuilder() {
    }

    public static OrderItemBuilder create() {
        return new OrderItemBuilder();
    }

    public OrderItemBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderItemBuilder withShoppingOrder(ShoppingOrder shoppingOrder) {
        this.shoppingOrder = shoppingOrder;
        return this;
    }

    public OrderItemBuilder withGrocery(Grocery grocery) {
        this.grocery = grocery;
        return this;
    }

    public OrderItemBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderItem build() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        orderItem.setShoppingOrder(shoppingOrder);
        orderItem.setGroceryId(grocery);
        orderItem.setQuantity(quantity);
        return orderItem;
    }
}
