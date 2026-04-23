package com.quickbite.backend.restaurant.repository;

import com.quickbite.backend.restaurant.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

    List<MenuItem> findByRestaurantId(Integer restaurantId);

    MenuItem findByName(String name);

    @Query("SELECT m FROM MenuItem m JOIN m.restaurant r WHERE r.name = :restaurantName")
    List<MenuItem> findByRestaurantName(String restaurantName);

}
