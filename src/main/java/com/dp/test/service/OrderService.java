package com.dp.test.service;

import com.dp.test.model.Order;
import com.dp.test.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(String customerName, String product, int quantity, BigDecimal price, String shippingAddress, String paymentMethod){
        Order order = new Order.OrderBuilder().setCustomerName(customerName).setProduct(product).setQuantity(quantity).
                setPrice(price).setShippingAddress(shippingAddress).setPaymentMethod(paymentMethod).build();
        return order;
    }

}
