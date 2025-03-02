package com.dp.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderRequestDTO {
    private String customerName;
    private String product;
    private int quantity;
    private BigDecimal price;
    private String shippingAddress;
    private String paymentMethod;
}
