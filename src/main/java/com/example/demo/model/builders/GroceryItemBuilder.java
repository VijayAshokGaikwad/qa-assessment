package com.example.demo.model.builders;

import com.example.demo.model.entity.Grocery;

public class GroceryItemBuilder {
    private Long id;
    private String name;
    private Float price;
    private Integer availableQuantity;

    private GroceryItemBuilder() {
    }

    public static GroceryItemBuilder create() {
        return new GroceryItemBuilder();
    }

    public GroceryItemBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public GroceryItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public GroceryItemBuilder withPrice(Float price) {
        this.price = price;
        return this;
    }

    public GroceryItemBuilder withQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
        return this;
    }

    public Grocery build() {
        Grocery grocery = new Grocery();
        grocery.setId(id);
        grocery.setName(name);
        grocery.setPrice(price);
        grocery.setAvailableQuantity(availableQuantity);
        return grocery;
    }
}
