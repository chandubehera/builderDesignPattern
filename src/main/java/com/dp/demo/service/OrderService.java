package com.dp.demo.service;

import com.dp.demo.dto.OrderRequestDTO;
import com.dp.demo.dto.OrderResponseDTO;
import com.dp.demo.entity.Order;
import com.dp.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public OrderResponseDTO createOrder(OrderRequestDTO requestDTO){
        Order order = Order.builder().customerName(requestDTO.getCustomerName())
                .product(requestDTO.getProduct())
                .quantity(requestDTO.getQuantity())
                .price(requestDTO.getPrice())
                .shippingAddress(requestDTO.getShippingAddress())
                .paymentMethod(requestDTO.getPaymentMethod())
                .orderDate(LocalDateTime.now()).build();

        //save to database
        Order savedOrder = orderRepository.save(order);

        return OrderResponseDTO.builder().id(savedOrder.getId()).build();
    }
}
