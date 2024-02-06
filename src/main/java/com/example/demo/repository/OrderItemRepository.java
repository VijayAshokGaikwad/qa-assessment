package com.example.demo.repository;

import com.example.demo.model.entity.Grocery;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.ShoppingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("select o from OrderItem o where o.shoppingOrder = :order")
    List<OrderItem> findAllWhereQuantityIsGreaterThanZero(@Param("order") ShoppingOrder order);
}
