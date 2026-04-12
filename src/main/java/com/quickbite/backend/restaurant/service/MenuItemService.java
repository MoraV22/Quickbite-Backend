package com.quickbite.backend.restaurant.service;

import com.quickbite.backend.restaurant.domain.MenuItem;
import com.quickbite.backend.restaurant.domain.Restaurant;
import com.quickbite.backend.restaurant.dto.MenuItemDTO;
import com.quickbite.backend.restaurant.repository.MenuItemRepository;
import com.quickbite.backend.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItemService(MenuItemRepository menuItemRepository,  RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public MenuItem createMenuItem(MenuItemDTO dto) {
        Restaurant restaurant= restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(()-> new IllegalArgumentException("Restaurant with id " + dto.getRestaurantId() + " does not exist"));
        MenuItem menuItem = new MenuItem();
        menuItem.setName(dto.getName());
        menuItem.setDescription(dto.getDescription());
        menuItem.setPrice(dto.getPrice());
        menuItem.setRestaurant(restaurant);
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> findAll(){
        return menuItemRepository.findAll();
    }

    public List<MenuItem> findByRestaurant(Integer restaurantId){
        return menuItemRepository.findByRestaurant(restaurantId);
    }

    public MenuItem updateMenuItem(MenuItemDTO dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(()-> new IllegalArgumentException("Restaurant with id " + dto.getRestaurantId() + " does not exist"));
        MenuItem menuItem = menuItemRepository.findById(dto.getId()).orElseThrow(()-> new IllegalArgumentException("Menu item with id " + dto.getId() + " does not exist"));
        menuItem.setName(dto.getName());
        menuItem.setDescription(dto.getDescription());
        menuItem.setPrice(dto.getPrice());
        menuItem.setRestaurant(restaurant);
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(Integer id) {
        if (!menuItemRepository.existsById(id)) {
            throw new IllegalArgumentException("Menu item with id " + id + " does not exist");
        }
        menuItemRepository.deleteById(id);
    }
}
