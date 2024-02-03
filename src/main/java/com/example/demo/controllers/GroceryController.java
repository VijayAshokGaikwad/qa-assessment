package com.example.demo.controllers;

import com.example.demo.model.entity.GroceryItem;
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
        List<GroceryItem> groceryItemItems = groceryService.getListOfGroceryItems();
        return ResponseEntity.ok(groceryItemItems);
    }

    @PostMapping("/grocery-items")
    public ResponseEntity addGroceryItems(@RequestBody List<GroceryItem> newGroceryItemItems) {
        groceryService.addGroceryItems(newGroceryItemItems);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/grocery-items/{itemId}")
    public ResponseEntity removeGroceryItem(@PathVariable Long itemId) {
        Optional<Long> deletedItem = groceryService.removeGroceryItem(itemId);
        return deletedItem.isPresent()
                ? ResponseEntity.ok(deletedItem.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/grocery-items")
    public ResponseEntity updateGroceryItem(@RequestBody GroceryItem groceryUpdateRequest) {
        Optional<GroceryItem> updateGroceryItem = groceryService.updateGroceryItem(groceryUpdateRequest);
        return updateGroceryItem.isPresent()
                ? ResponseEntity.ok(updateGroceryItem.get())
                : ResponseEntity.notFound().build();
    }
}
