package com.quickbite.backend.restaurant.service;


import com.quickbite.backend.restaurant.domain.Restaurant;
import com.quickbite.backend.restaurant.dto.RestaurantDTO;
import com.quickbite.backend.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
     }


    // CREATE RESTAURANT
    public Restaurant createRestaurant(RestaurantDTO dto) {

        //check for name already exists
        if (restaurantRepository.findByName(dto.getName()).isPresent()) {
            throw new IllegalArgumentException("Restaurant name already exists");
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setFoodType(dto.getFoodType());
        restaurant.setRate(dto.getRate() != null ? dto.getRate() : 1);
        restaurant.setOpenHour(dto.getOpenHour());
        restaurant.setCloseHour(dto.getCloseHour());
        restaurant.setAddress(dto.getAddress());
        restaurant.setRate(dto.getRate() != null ? dto.getRate() : 1);
        return restaurantRepository.save(restaurant);
    }

    // GET RESTAURANT BY ID
    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with id: " + id));
    }

    // GET RESTAURANT BY NAME
    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with name: " + name));
    }

    // GET OPEN RESTAURANTS
    public List<Restaurant> getOpenRestaurants() {
        return restaurantRepository.findAnyOpen(java.time.LocalTime.now());
    }

    // GET RESTAURANTS BY FOOD TYPE
    public List<Restaurant> getRestaurantsByFoodType(String foodType) {
        return restaurantRepository.findByFoodType(foodType);
    }

    // GET RESTAURANTS BY RATE
    public List<Restaurant> getRestaurantsByRate(Integer rate) {
        return restaurantRepository.findByRateGreaterThanEqual(rate);
    }

        // GET ALL RESTAURANTS
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

        // UPDATE RESTAURANT
    public Restaurant updateRestaurant(Integer id, RestaurantDTO dto) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with id: " + id));
    }

        // DELETE RESTAURANT
    public void deleteRestaurant(Integer id) {
        if (!restaurantRepository.existsById(id)) {
            throw new IllegalArgumentException("Restaurant not found with id: " + id);
        }
        restaurantRepository.deleteById(id);}
}
