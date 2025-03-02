package com.dp.demo.controller;

import com.dp.demo.dto.OrderResponseDTO;
import com.dp.demo.entity.Order;
import com.dp.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

   /* @PostMapping("/create")
    public Map<String,Long> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.createOrder(order);
        return Collections.singletonMap("id",savedOrder.getId());
    }*/

    @PostMapping("/create")
    public OrderResponseDTO createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.createOrder(order);
        return new OrderResponseDTO(savedOrder.getId());
    }
}
