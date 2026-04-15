package com.quickbite.backend.order.controller;

import com.quickbite.backend.order.domain.Order;
import com.quickbite.backend.order.dto.OrderDTO;
import com.quickbite.backend.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * create an order
     * POST /api/order
     */
    @PostMapping
    public ResponseEntity<Order> updatePaymentInfo(@RequestBody OrderDTO orderDTO){
        Order createdOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    /**
     * update and order
     * PUT /api/order/id/{id}
     */
    @PutMapping("/id/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id,@Valid @RequestBody OrderDTO orderDTO) {
        if(!Objects.equals(id, orderDTO.getId())){
            return ResponseEntity.badRequest().build();
        }
        Order updatedOrder = orderService.updateOrder(orderDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    /**
     * get order by id
     * GET /api/order/id/{id}
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    /**
     * get all orders od one user
     * GET /api/order/userId/{userId}
     */
    @GetMapping("userId/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Integer userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }
}
