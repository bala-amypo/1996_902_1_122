package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;
    private int totalTransactions;
    private double roiPercentage;

    @ManyToOne
    private DiscountCode discountCode;

    public BigDecimal getTotalSales() { return totalSales; }
    public int getTotalTransactions() { return totalTransactions; }
    public double getRoiPercentage() { return roiPercentage; }
    public DiscountCode getDiscountCode() { return discountCode; }

    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalTransactions(int totalTransactions) { this.totalTransactions = totalTransactions; }
    public void setRoiPercentage(double roiPercentage) { this.roiPercentage = roiPercentage; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
}
