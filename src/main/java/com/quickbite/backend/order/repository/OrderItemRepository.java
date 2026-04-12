package com.quickbite.backend.order.repository;

import com.quickbite.backend.order.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findByOrderId(Integer orderId);

    Optional<OrderItem> findById(Integer id);

    OrderItem save(OrderItem orderItem);

    Boolean existsById(Integer orderId);

    void deleteById(Integer orderId);

}
