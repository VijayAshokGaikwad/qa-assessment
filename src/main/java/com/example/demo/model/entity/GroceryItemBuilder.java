package com.example.demo.model.entity;

public class GroceryItemBuilder {
    private Long id;
    private String name;
    private Float price;

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

    public GroceryItem build() {
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setId(id);
        groceryItem.setName(name);
        groceryItem.setPrice(price);
        return groceryItem;
    }
}
