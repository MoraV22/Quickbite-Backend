package com.quickbite.backend.order.repository;

import com.quickbite.backend.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value="SELECT o FROM orders o WHERE o.id_user= :userId", nativeQuery = true)
    List<Order> findByUser(Integer userId);

}
