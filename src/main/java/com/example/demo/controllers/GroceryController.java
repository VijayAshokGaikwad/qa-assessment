package com.example.demo.controllers;

import com.example.demo.model.Grocery;
import com.example.demo.service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity addGroceryItems(@RequestBody List<Grocery> newGroceryItems) {
        groceryService.addGroceryItems(newGroceryItems);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/grocery-items/{itemId}")
    public ResponseEntity removeGroceryItem(@PathVariable Long itemId) {
        Optional<Long> deletedItem = groceryService.removeGroceryItem(itemId);
        return deletedItem.isPresent()
                ? ResponseEntity.ok(deletedItem.get())
                : ResponseEntity.notFound().build();
    }
}
