package com.quickbite.backend.order.service;

import com.quickbite.backend.order.domain.Order;
import com.quickbite.backend.order.dto.OrderDTO;
import com.quickbite.backend.order.repository.OrderRepository;
import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {

        // Implement logic to create an order
        Order order = new Order();
        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        order.setUser(user);
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setCreatedAt(orderDTO.getCreatedAt());
        order.setAddress(orderDTO.getAddress());
        order.setStatus(orderDTO.getStatus());
        order.setTax(orderDTO.getTax());

        // Save order to repository
        return orderRepository.save(order);
    }

    //Update
    public Order updateOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Order order = orderRepository.findById(orderDTO.getId()).orElseThrow(() -> new RuntimeException("Order not found"));

        //Just being able to update status
        order.setStatus(orderDTO.getStatus());
        return orderRepository.save(order);
    }

}
