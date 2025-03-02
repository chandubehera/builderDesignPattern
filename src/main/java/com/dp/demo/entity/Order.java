package com.dp.demo.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String product;
    private int quantity;
    private BigDecimal price;
    private String shippingAddress;
    private String paymentMethod;
    private String orderStatus;
    private LocalDateTime orderDate;

    public Order(){

    }
    private Order(OrderBuilder builder){
        this.customerName=builder.customerName;
        this.product=builder.product;
        this.quantity=builder.quantity;
        this.price=builder.price;
        this.shippingAddress=builder.shippingAddress;
        this.paymentMethod=builder.paymentMethod;
        this.orderStatus=builder.orderStatus;
        this.orderDate=builder.orderDate;
    }

    public static class OrderBuilder{

        private Long id;
        private String customerName;
        private String product;
        private int quantity;
        private BigDecimal price;
        private String shippingAddress;
        private String paymentMethod;
        private String orderStatus = "PENDING";
        private LocalDateTime orderDate = LocalDateTime.now();

        public OrderBuilder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public OrderBuilder setProduct(String product) {
            this.product = product;
            return this;
        }

        public OrderBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderBuilder setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public OrderBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public OrderBuilder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public OrderBuilder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }

    public Long getId(){
        return id;
    }
    public String getCustomerName() {
        return customerName;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
