package com.example.demo.service;

import com.example.demo.model.entity.Grocery;
import com.example.demo.model.builders.GroceryItemBuilder;
import com.example.demo.repository.GroceryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final GroceryRepository groceryRepository;

    @Autowired
    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<Grocery> getAllGroceryItems() {
        return groceryRepository.findAll();
    }

    public List<Grocery> getAvailableGroceryItems() {
        int minimumQuantity = 0;
        return groceryRepository.findAllByAvailableQuantityGreaterThan(minimumQuantity);
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

    public Optional<Grocery> updateGroceryItem(Grocery groceryUpdateRequest) {
        Optional<Grocery> originalItem = groceryRepository.findById(groceryUpdateRequest.getId());

        if (originalItem.isPresent()) {
            Grocery updatedGrocery = GroceryItemBuilder.create()
                    .withId(groceryUpdateRequest.getId())
                    .withName(groceryUpdateRequest.getName())
                    .withPrice(groceryUpdateRequest.getPrice())
                    .withQuantity(groceryUpdateRequest.getAvailableQuantity())
                    .build();

            return Optional.of(groceryRepository.save(updatedGrocery));
        } else {
            return Optional.empty();
        }
    }
}
