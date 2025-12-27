package com.example.demo.entity;

import jakarta.persistence.*;

@Entity                          // ✅ Marks this class as JPA entity
@Table(name = "users")           // ✅ Maps to table "users"
public class User {

    @Id                          // ✅ REQUIRED (without this app will crash)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    // ✅ REQUIRED: No-args constructor
    public User() {
    }

    // Optional constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
