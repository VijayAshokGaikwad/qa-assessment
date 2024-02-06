package com.example.demo.model.response;

import com.example.demo.model.entity.Grocery;
import com.example.demo.model.entity.ShoppingOrder;
import jakarta.persistence.*;

public class OrderItemResponse {
    private Long id;
    private Long groceryId;
    private int quantity;

    public OrderItemResponse(Long id, Long groceryId, int quantity) {
        this.id = id;
        this.groceryId = groceryId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
