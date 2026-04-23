package com.quickbite.backend.restaurant.service;


import com.quickbite.backend.restaurant.domain.Restaurant;
import com.quickbite.backend.restaurant.dto.RestaurantDTO;
import com.quickbite.backend.restaurant.repository.RestaurantRepository;
import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.quickbite.backend.user.dto.RoleType;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
     }


    // CREATE RESTAURANT
    public Restaurant createRestaurant(RestaurantDTO dto) {

        //check for name already exists
        if (restaurantRepository.findByName(dto.getName()).isPresent()) {
            throw new IllegalArgumentException("Restaurant name already exists");
        }

        User owner = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + dto.getUserId()));
        if(owner.getUserType() != RoleType.RESTAURANT_OWNER) {
            throw new IllegalArgumentException("User with id: " + dto.getUserId() + " is not an owner");
        }
        Restaurant restaurant = new Restaurant();
        restaurantFromDTO(dto, restaurant,owner);
        restaurant.setRate(dto.getRate() != null ? dto.getRate() : 1);
        return restaurantRepository.save(restaurant);
    }

    private void restaurantFromDTO(RestaurantDTO dto, Restaurant restaurant, User owner) {
        restaurant.setUser(owner);
        restaurant.setName(dto.getName());
        restaurant.setFoodType(dto.getFoodType());
        restaurant.setRate(dto.getRate() != null ? dto.getRate() : 3);
        restaurant.setOpenHour(dto.getOpenHour());
        restaurant.setCloseHour(dto.getCloseHour());
        restaurant.setAddress(dto.getAddress());
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


    // GET RESTAURANTS BY RATE
    public List<Restaurant> getRestaurantsByRate(Integer rate) {
        return restaurantRepository.findByRateGreaterThanEqual(rate);
    }

    // GET RESTAURANTS BY OWNER
    public List<Restaurant> getRestaurantsByOwner(Integer ownerId) {
        return restaurantRepository.findByUserId(ownerId);
    }

        // GET ALL RESTAURANTS
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

     // GET ALL FOOD TYPES
    public List<String> getAllFoodTypes() {
        return restaurantRepository.findFoodTypes();
    }

        // UPDATE RESTAURANT

// GET RESTAURANTS BY FOOD TYPE
    public List<Restaurant> getByFoodType(String foodType) {
        return restaurantRepository.findByFoodType(foodType);
    }
    public Restaurant updateRestaurant(Integer id, RestaurantDTO dto) {

        Restaurant restaurant= restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Restaurant not found with id: " + id));
        User owner= userRepository.findById(dto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + dto.getUserId()));
        restaurantFromDTO(dto, restaurant, owner);

        return restaurantRepository.save(restaurant);


    }

        // DELETE RESTAURANT
    public void deleteRestaurant(Integer id) {
        if (!restaurantRepository.existsById(id)) {
            throw new IllegalArgumentException("Restaurant not found with id: " + id);
        }
        restaurantRepository.deleteById(id);}
}
