package com.quickbite.backend.restaurant.repository;

import com.quickbite.backend.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Optional<Restaurant> findByAddress(String address);

    List<Restaurant> findByFoodType(String foodType);

    List<Restaurant> findByRateGreaterThanEqual(Integer rate);

}