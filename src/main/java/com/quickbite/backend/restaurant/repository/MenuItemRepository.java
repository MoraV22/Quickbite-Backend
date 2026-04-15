package com.quickbite.backend.restaurant.repository;

import com.quickbite.backend.restaurant.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

    @Query(value = "SELECT m FROM menu_items m WHERE m.restaurant_id= :restaurantId", nativeQuery = true)
    List<MenuItem> findByRestaurant(@Param("restaurantId") Integer restaurantId);

    @Query(value = "DELETE FROM menu_items m WHERE m.id= :id", nativeQuery = true)
    void deleteById(@Param("id") Integer id);
}
