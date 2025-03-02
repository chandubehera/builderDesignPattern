package com.dp.demo.controller;

import com.dp.demo.dto.OrderRequestDTO;
import com.dp.demo.dto.OrderResponseDTO;
import com.dp.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO requestDTO) {
        return orderService.createOrder(requestDTO);
    }
}
