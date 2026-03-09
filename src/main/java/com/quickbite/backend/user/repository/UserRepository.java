package com.quickbite.backend.user.repository;

import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.dto.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);

    Optional<User> findById(Integer id);

    Optional<RoleType> getUserTypeById(Integer id);

    Optional<Integer> getUserRateById(Integer id);
}
