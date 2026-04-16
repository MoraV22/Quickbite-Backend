package com.quickbite.backend.restaurant.controller;

import com.quickbite.backend.restaurant.domain.MenuItem;
import com.quickbite.backend.restaurant.dto.MenuItemDTO;
import com.quickbite.backend.restaurant.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/menu-item")
@CrossOrigin(origins = "*")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public  MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }
    /**
     * post new menu item
     * POST /api/menu-item
     */
    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@Valid @RequestBody MenuItemDTO menuItemDTO){
        MenuItem menuItemCreated = menuItemService.createMenuItem(menuItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItemCreated);
    }

    /**
     * get all menu items
     * GET /api/menu-item
     */
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems()
    {
        List<MenuItem> menuItems = menuItemService.findAll();
        return ResponseEntity.ok(menuItems);
    }

    /**
     * get menu items by restaurant
     * GET /api/menu-item/restaurantId/{restaurantId}
     */
    @GetMapping("/restaurantId/{restaurantId}")
    public ResponseEntity<List<MenuItem>> getAllMenuItemsByRestaurant(@PathVariable Integer restaurantId){
        List<MenuItem> menuItems = menuItemService.findByRestaurant(restaurantId);
        return ResponseEntity.ok(menuItems);
    }

    /**
     * update a menu item
     * PUT /api/menu-item/id/{id}
     */
    @PutMapping("/id/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Integer id, @RequestBody MenuItemDTO menuItemDTO){
        if(!Objects.equals(id, menuItemDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }
        MenuItem menuItemUpdated = menuItemService.updateMenuItem(menuItemDTO);
        return ResponseEntity.ok(menuItemUpdated);
    }

    /**
     * delete menu item
     * DELETE /api/menu-item/id/{id}
     */
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Integer id){
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}

