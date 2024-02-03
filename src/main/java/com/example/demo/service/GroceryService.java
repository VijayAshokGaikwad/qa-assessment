package com.example.demo.service;

import com.example.demo.model.Grocery;
import com.example.demo.repository.GroceryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GroceryService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<Grocery> getListOfGroceryItems() {
        return groceryRepository.findAll();
    }

    public void addGroceryItems(List<Grocery> newGroceryItems) {
        try {
            groceryRepository.saveAll(newGroceryItems);
        } catch (Exception exception) {
            logger.error("Error occurred while saving grocery items");
        }
    }

    public Optional<Long> removeGroceryItem(Long itemId) {
        boolean itemExists = groceryRepository.existsById(itemId);

        if (itemExists) {
            groceryRepository.deleteById(itemId);
            return Optional.of(itemId);
        } else {
            return Optional.empty();
        }
    }
}
