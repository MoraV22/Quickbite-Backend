package com.quickbite.backend.user.repository;

import com.quickbite.backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    
    Optional<User> findByName(String name);

    Optional<User> findById(Integer userId);

    User save(User user);

    Boolean existsById(Integer id);

    void deleteById(Integer id);
}
