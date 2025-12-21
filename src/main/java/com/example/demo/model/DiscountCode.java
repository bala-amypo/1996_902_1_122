package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "discount_codes",
    uniqueConstraints = @UniqueConstraint(columnNames = "code")
)
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private Double discountPercentage;

    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    private Boolean active = true;

    public DiscountCode() {}

    @PrePersist
    public void onCreate() {
        if (active == null) {
            active = true;
        }
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(Double discountPercentage) { this.discountPercentage = discountPercentage; }

    public Influencer getInfluencer() { return influencer; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }

    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
