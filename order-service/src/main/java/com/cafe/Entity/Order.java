package com.cafe.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING; // Enum for better status management

    private String paymentStatus = "INCOMPLETE";

    @ElementCollection
    private List<Long> productIds;

    private Double totalAmount;

    public Order() {}

    public Order(Long userId, List<Long> productIds, OrderStatus status) {
        this.userId = userId;
        this.productIds = productIds;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        if ("COMPLETE".equals(paymentStatus)) {
            this.status = OrderStatus.CONFIRMED; // Auto-update status when payment is done
        }
    }

    public List<Long> getProductIds() { return productIds; }
    public void setProductIds(List<Long> productIds) { this.productIds = productIds; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
}
