package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal transactionAmount;
    private Timestamp transactionDate;
    private Long customerId;

    @ManyToOne
    private DiscountCode discountCode;

    public Long getId() { return id; }
    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public Timestamp getTransactionDate() { return transactionDate; }
    public Long getCustomerId() { return customerId; }
    public DiscountCode getDiscountCode() { return discountCode; }

    public void setId(Long id) { this.id = id; }
    public void setTransactionAmount(BigDecimal transactionAmount) { this.transactionAmount = transactionAmount; }
    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
}
