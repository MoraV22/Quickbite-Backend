package com.quickbite.backend.order.service;

import com.quickbite.backend.order.domain.Order;
import com.quickbite.backend.order.domain.OrderItem;
import com.quickbite.backend.order.dto.OrderDTO;
import com.quickbite.backend.order.dto.OrderItemDTO;
import com.quickbite.backend.order.repository.OrderItemRepository;
import com.quickbite.backend.order.repository.OrderRepository;
import com.quickbite.backend.restaurant.domain.MenuItem;
import com.quickbite.backend.restaurant.repository.MenuItemRepository;
import com.quickbite.backend.user.domain.User;
import com.quickbite.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository,UserRepository userRepository, MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.menuItemRepository = menuItemRepository;
    }

    // CREATE: Full order with items
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setAddress(orderDTO.getAddress());
        order.setStatus(orderDTO.getStatus());
        order.setCreatedAt(orderDTO.getCreatedAt());

        double totalPrice = 0.0;

        if (orderDTO.getItems() != null && !orderDTO.getItems().isEmpty()) {
            for (OrderItemDTO item : orderDTO.getItems()) {
                totalPrice += item.getPrice() * item.getQuantity();
            }
        } else {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        double tax = totalPrice *.16;
        order.setTax(tax);
        order.setTotalPrice(totalPrice+tax);
        orderRepository.save(order);
        List<OrderItem> orderItems = new ArrayList<>();

        // Add items to order
        if (orderDTO.getItems() != null && !orderDTO.getItems().isEmpty()) {
            orderDTO.getItems().forEach(itemDTO -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                MenuItem menuItem = menuItemRepository.findById(itemDTO.getIdItem())
                        .orElseThrow(() -> new RuntimeException("MenuItem not found"));
                orderItem.setMenuItem(menuItem);
                orderItem.setQuantity(itemDTO.getQuantity());
                orderItem.setPrice(itemDTO.getPrice());
                orderItemRepository.save(orderItem);
                orderItems.add(orderItem);

            });
        }
        order.setOrderItems(orderItems);
        return order;
    }

    // UPDATE: Order status/address
    public Order updateOrder(OrderDTO orderDTO) {
        Order order = orderRepository.findById(orderDTO.getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(orderDTO.getStatus());
        order.setAddress(orderDTO.getAddress());

        return orderRepository.save(order);
    }

    // GET: Single order (includes OrderItems)
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // GET: Orders by user
    public List<Order> getOrdersByUserId(Integer userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findByUserId(userId);
    }
}
