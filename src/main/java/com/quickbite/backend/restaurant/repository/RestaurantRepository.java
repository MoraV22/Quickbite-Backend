package com.quickbite.backend.restaurant.repository;

import com.quickbite.backend.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findAnyOpen(LocalTime now);

    List<Restaurant> findByFoodType(String foodType);

    List<Restaurant> findByRateGreaterThanEqual(Integer rate);

    Optional<Restaurant> findById(Integer id);

    Optional<Restaurant> findByName(String name);

    Restaurant save(Restaurant restaurant);

    Boolean existsById(Integer id);

    void deleteById(Integer id);

}