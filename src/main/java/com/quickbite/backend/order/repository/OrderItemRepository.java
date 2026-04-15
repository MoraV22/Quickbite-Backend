package com.quickbite.backend.order.repository;

import com.quickbite.backend.order.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query(value = "DELETE FROM order_items o WHERE o.id= :id", nativeQuery = true)
    void deleteById(@Param("id")Integer id);

}
