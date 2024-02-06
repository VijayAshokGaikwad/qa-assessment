package com.example.demo.model.response;

import java.util.List;

public class ShoppingOrderResponse {

    private Long id;
    private List<OrderItemResponse> orderItems;

    public ShoppingOrderResponse(Long id, List<OrderItemResponse> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItemResponse> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemResponse> orderItems) {
        this.orderItems = orderItems;
    }
}
