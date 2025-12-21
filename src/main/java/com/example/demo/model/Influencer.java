package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "influencers",
    uniqueConstraints = @UniqueConstraint(columnNames = "social_handle")
)
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "social_handle", nullable = false, unique = true)
    private String socialHandle;

    private String email;

    private Boolean active = true;

    private LocalDateTime createdAt;

    public Influencer() {}

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        if (active == null) {
            active = true;
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSocialHandle() { return socialHandle; }
    public void setSocialHandle(String socialHandle) { this.socialHandle = socialHandle; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
