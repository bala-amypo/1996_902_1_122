package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
    name = "campaigns",
    uniqueConstraints = @UniqueConstraint(columnNames = "campaign_name")
)
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campaign_name", nullable = false, unique = true)
    private String campaignName;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(precision = 19, scale = 2)
    private BigDecimal budget;

    private Boolean active = true;

    public Campaign() {}

    @PrePersist
    public void onCreate() {
        if (active == null) {
            active = true;
        }
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
