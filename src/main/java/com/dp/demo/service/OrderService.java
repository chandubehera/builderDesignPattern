package com.dp.demo.service;

import com.dp.demo.entity.Order;
import com.dp.demo.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Order createOrder(Order order){
        Order savedOrder = new Order.OrderBuilder().setCustomerName(order.getCustomerName()).setProduct(order.getProduct()).setQuantity(order.getQuantity()).
                setPrice(order.getPrice()).setShippingAddress(order.getShippingAddress()).setPaymentMethod(order.getPaymentMethod()).build();
        orderRepository.save(savedOrder);
        entityManager.flush();  // ✅ Forces DB insert before fetching ID
        System.out.println("Saved Order ID (After Flush): " + order.getId());

        return order;
    }

}
