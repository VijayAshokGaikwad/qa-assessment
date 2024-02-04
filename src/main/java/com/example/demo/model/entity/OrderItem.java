package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private ShoppingOrder shoppingOrder;

    @ManyToOne
    @JoinColumn(name = "grocery_id")
    private Grocery groceryId;

    private int quantity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingOrder getShoppingOrder() {
        return shoppingOrder;
    }

    public void setShoppingOrder(ShoppingOrder shoppingOrder) {
        this.shoppingOrder = shoppingOrder;
    }

    public void setItem(Grocery item) {
        this.groceryId = item;
    }

    public Grocery getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(Grocery groceryId) {
        this.groceryId = groceryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
