package com.quickbite.backend.user.repository;

import com.quickbite.backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM users u WHERE u.email= :email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "SELECT u from users u WHERE u.name = :name",  nativeQuery = true)
    Optional<User> findByName(@Param("name") String name);

    @Query(value = "DELETE FROM users u WHERE u.id= :id", nativeQuery = true)
    void deleteById(@Param(("id")) Integer id);
}
