package com.quickbite.backend.order.repository;

import com.quickbite.backend.order.domain.Order;
import com.quickbite.backend.order.dto.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser(Integer userId);

    Optional<Order> findById(Integer orderId);

    OrderStatus getOrderStatus(Integer orderId);

    Boolean existsById(Integer orderId);

    Order save(Order order);

    void deleteById(Integer orderId);

}
