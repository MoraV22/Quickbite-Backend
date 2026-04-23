package com.quickbite.backend.restaurant.controller;

import com.quickbite.backend.restaurant.domain.Restaurant;
import com.quickbite.backend.restaurant.dto.RestaurantDTO;
import com.quickbite.backend.restaurant.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@CrossOrigin(origins = "*")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public  RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /**
     * Create a new user
     * POST /api/restaurant
     */
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    /**
     * Get restaurant by ID
     * GET /api/restaurant/{id}
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Integer id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

    /**
     * Get restaurant by name
     * GET /api/restaurant/name/{name}
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Restaurant> getRestaurantByName(@PathVariable String name) {
        Restaurant restaurant = restaurantService.getRestaurantByName(name);
        return ResponseEntity.ok(restaurant);
    }

    /**
     * Get open restaurants
     * GET /api/restaurant/open
     */
    @GetMapping("/open")
    public ResponseEntity<List<Restaurant>> getRestaurantByOpen() {
        List<Restaurant> restaurants = restaurantService.getOpenRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    /**
     * Get restaurant by rate
     * GET /api/restaurant/rate/{rate}
     */
    @GetMapping("/rate/{rate}")
    public ResponseEntity<List<Restaurant>> getRestaurantByRate(@PathVariable Integer rate) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsByRate(rate);
        return ResponseEntity.ok(restaurants);
    }

    /**
     * Get all restaurants
     * GET /api/restaurant/
     */

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    /**
     * Get all restaurants by owner
     * GET /api/restaurant/ownerId/{ownerId}
     */

    @GetMapping("/ownerId/{ownerId}")
    public ResponseEntity<List<Restaurant>> getAllRestaurantsByOwnerId(@PathVariable Integer ownerId) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsByOwner(ownerId);
        return ResponseEntity.ok(restaurants);
    }

    /**
     * Get restaurant by food type
     * GET /api/restaurant/foodType/{foodType}
     */
    @GetMapping("/foodType/{foodType}")
    public ResponseEntity<List<Restaurant>> getAllRestaurantsByFoodType(@PathVariable String foodType) {
        List<Restaurant> response = restaurantService.getByFoodType(foodType);
        return ResponseEntity.ok(response);
    }

    /**
     * Update restaurant info
     * PUT /api/restaurant/id/{id}
     */
    @PutMapping("/id/{id}")
    public ResponseEntity<Restaurant>  updateRestaurant(@PathVariable Integer id, @RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantService.updateRestaurant(id, restaurantDTO);
        return ResponseEntity.ok(restaurant);
    }

    /**
     * Delete restaurant
     * DELETE /api/restaurant/id/{id}
     */
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

}