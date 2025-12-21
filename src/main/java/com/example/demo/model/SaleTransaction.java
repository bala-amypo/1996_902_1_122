package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale_transactions")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discount_code_id", nullable = false)
    private DiscountCode discountCode;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal saleAmount;

    private LocalDateTime transactionDate;

    public SaleTransaction() {}

    @PrePersist
    public void onCreate() {
        if (transactionDate == null) {
            transactionDate = LocalDateTime.now();
        }
    }

    // Getters & Setters
    public Long getId() { return id; }

    public DiscountCode getDiscountCode() { return discountCode; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }

    public BigDecimal getSaleAmount() { return saleAmount; }
    public void setSaleAmount(BigDecimal saleAmount) { this.saleAmount = saleAmount; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
}
