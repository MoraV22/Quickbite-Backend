package com.quickbite.backend.order.service;


import com.quickbite.backend.order.domain.Order;
import com.quickbite.backend.order.domain.OrderItem;
import com.quickbite.backend.order.dto.OrderItemDTO;
import com.quickbite.backend.order.repository.OrderItemRepository;
import com.quickbite.backend.order.repository.OrderRepository;
import com.quickbite.backend.restaurant.domain.MenuItem;
import com.quickbite.backend.restaurant.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, OrderRepository orderRepository, MenuItemRepository menuItemRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public OrderItem createOrderItem(OrderItemDTO dto) {

        Order order = orderRepository.findById(dto.getIdOrder()).orElseThrow(()-> new IllegalArgumentException("Order with id " + dto.getIdOrder() + " does not exist"));
        MenuItem menuItem= menuItemRepository.findById(dto.getIdItem()).orElseThrow(()-> new IllegalArgumentException("Menu item with id " + dto.getIdItem() + " does not exist"));
        OrderItem orderItem= new OrderItem();

        orderItem.setOrder(order);
        orderItem.setPrice(dto.getPrice());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setMenuItem(menuItem);

        return orderItemRepository.save(orderItem);

    }

    public OrderItem updateOrderItem(OrderItemDTO dto) {
        OrderItem orderItem = orderItemRepository.findById(dto.getId()).orElseThrow(()-> new IllegalArgumentException("Order item with id " + dto.getId() + " does not exist") );
        MenuItem menuItem= menuItemRepository.findById(dto.getIdItem()).orElseThrow(()-> new IllegalArgumentException("Menu item with id " + dto.getIdItem() + " does not exist"));

        orderItem.setPrice(dto.getPrice());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setMenuItem(menuItem);

        return orderItemRepository.save(orderItem);
    }

     public void deleteOrderItem(Integer id) {
         if (!orderItemRepository.existsById(id)) {
             throw new IllegalArgumentException("Order item with id " + id + " does not exist");
         }
         orderItemRepository.deleteById(id);
     }

     public List<OrderItem> getOrderItemsByOrder(Integer orderId){
        if (!orderItemRepository.existsById(orderId)){
            throw new IllegalArgumentException("Order item with id " + orderId + " does not exist");
        }
        return orderItemRepository.findByOrderId(orderId);

     }

}
