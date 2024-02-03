package com.example.demo.service;

import com.example.demo.model.entity.GroceryItem;
import com.example.demo.model.entity.GroceryItemBuilder;
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

    public List<GroceryItem> getListOfGroceryItems() {
        return groceryRepository.findAll();
    }

    public void addGroceryItems(List<GroceryItem> newGroceryItemItems) {
        try {
            groceryRepository.saveAll(newGroceryItemItems);
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

    public Optional<GroceryItem> updateGroceryItem(GroceryItem groceryUpdateRequest) {
        Optional<GroceryItem> originalItem = groceryRepository.findById(groceryUpdateRequest.getId());

        if (originalItem.isPresent()) {
            GroceryItem updatedGroceryItem = GroceryItemBuilder.create()
                    .withId(groceryUpdateRequest.getId())
                    .withName(groceryUpdateRequest.getName())
                    .withPrice(groceryUpdateRequest.getPrice())
                    .build();

            return Optional.of(groceryRepository.save(updatedGroceryItem));
        } else {
            return Optional.empty();
        }
    }
}
