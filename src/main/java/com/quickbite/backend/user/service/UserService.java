package com.quickbite.backend.user.service;


import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.dto.UserDTO;
import com.quickbite.backend.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // CREATE USER
    public User createUser(UserDTO dto){

        // Check if email already exists
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();

        user.setName(dto.getName());
        user.setSurname1(dto.getSurname1());
        user.setSurname2(dto.getSurname2());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setUserType(dto.getUserType());
        user.setRate(dto.getRate() != null ? dto.getRate() : 1);

        return userRepository.save(user);
    }

    // GET USER BY ID
    public User getUserById(Integer id){

        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    // GET ALL USERS
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // GET USER BY NAME
    public User getUserByName(String name){

        return userRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("User not found with name: " + name));
    }



    // UPDATE USER
    public User updateUser(UserDTO dto){

        User user = userRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + dto.getId()));

        if (!user.getEmail().equals(dto.getEmail()) && userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        user.setName(dto.getName());
        user.setSurname1(dto.getSurname1());
        user.setSurname2(dto.getSurname2());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setUserType(dto.getUserType());
        user.setEmail(dto.getEmail());
        user.setRate(dto.getRate() != null ? dto.getRate() : 1);
        user.setPassword(dto.getPassword());

        return userRepository.save(user);
    }

    // DELETE USER
    public void deleteUser(Integer id){

        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }

}