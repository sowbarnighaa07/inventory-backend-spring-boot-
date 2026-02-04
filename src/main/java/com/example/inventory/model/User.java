package com.example.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}