package com.quickbite.backend.restaurant.repository;

import com.quickbite.backend.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(value = "SELECT r FROM restaurants r WHERE r.openhour <= :now AND r.closehour >= :now", nativeQuery = true)
    List<Restaurant> findAnyOpen(@Param("now") LocalTime now);

    @Query(value = "SELECT r FROM restaurants r WHERE r.rate >= :rate", nativeQuery = true)
    List<Restaurant> findByRateGreaterThanEqual(@Param("rate")Integer rate);

    Optional<Restaurant> findByName(String name);

}