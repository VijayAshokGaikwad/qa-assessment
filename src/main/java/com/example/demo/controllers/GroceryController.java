package com.example.demo.controllers;

import com.example.demo.model.Grocery;
import com.example.demo.service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/grocery-items")
    public ResponseEntity getListOfGroceryItems() {
        List<Grocery> groceryItems = groceryService.getListOfGroceryItems();
        return ResponseEntity.ok(groceryItems);
    }

    @PostMapping("/grocery-items")
    public ResponseEntity addGroceryItems(List<Grocery> newGroceryItems) {
        groceryService.addGroceryItems(newGroceryItems);
        return ResponseEntity.ok().build();
    }
}
