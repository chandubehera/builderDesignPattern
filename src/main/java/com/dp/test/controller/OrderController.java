package com.dp.test.controller;

import com.dp.test.model.Order;
import com.dp.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order.getCustomerName(),order.getProduct(),order.getQuantity(),order.getPrice(),order.getShippingAddress(),order.getPaymentMethod());
    }

    /*@GetMapping({"/id"})
    public Order getOrder(@RequestMapping Long orderId){

    }*/
}
