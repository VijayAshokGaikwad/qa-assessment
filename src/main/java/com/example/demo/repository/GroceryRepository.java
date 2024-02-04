package com.example.demo.repository;

import com.example.demo.model.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {

    @Query("select g from Grocery g where g.availableQuantity > 0")
    List<Grocery> findAllWhereQuantityIsGreaterThanZero();
}
