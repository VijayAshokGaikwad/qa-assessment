package com.example.demo.service;

import com.example.demo.model.Grocery;
import com.example.demo.repository.GroceryRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GroceryService {

    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<Grocery> getListOfGroceryItems() {
        return groceryRepository.findAll();
    }
}
