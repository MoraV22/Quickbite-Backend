package com.quickbite.backend.user.controller;

import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.dto.AuthUserDTO;
import com.quickbite.backend.user.dto.UserDTO;
import com.quickbite.backend.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user
     * POST /api/user
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        User createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Get all user
     * GET /api/user
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Get user by ID
     * GET /api/user/id/{id}
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Authenticate user by email and password
     * GET /api/user/auth
     */

    @PostMapping("/auth")
    public ResponseEntity<User> getUserByEmail(@Valid @RequestBody AuthUserDTO  authUserDTO) {
        User response = userService.auth(authUserDTO);
        return ResponseEntity.ok(response);
    }

    /**
     * Get user by name
     * GET /api/user/name/{name}
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        User user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    /**
     * Update user information
     * PUT /api/user/id/{id}
     */
    @PutMapping("/id/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer id,
            @Valid @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(userDTO, id);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete a user
     * DELETE /api/user/id/{id}
     */
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
