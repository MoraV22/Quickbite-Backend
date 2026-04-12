package com.quickbite.backend.restaurant.repository;

import com.quickbite.backend.restaurant.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    Optional<MenuItem> findByName(String name);

    Optional<MenuItem> findById(Integer id);

    List<MenuItem> findByRestaurant(Integer restaurantId);

    MenuItem save(MenuItem menuItem);

    Boolean existsById(Integer id);

    void deleteById(Integer id);
}
