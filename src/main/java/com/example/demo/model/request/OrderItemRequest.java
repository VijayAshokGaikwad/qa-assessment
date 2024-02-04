package com.example.demo.model.request;

public class OrderItemRequest {
    private Long groceryId;
    private int quantity;

    public Long getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(Long groceryId) {
        this.groceryId = groceryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
