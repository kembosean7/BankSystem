package com.example.demo;


import jakarta.persistence.*;

@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        ))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId_sequence")
    @SequenceGenerator(sequenceName = "userId_sequence", name = "userId_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private Double balance;
    private String type;

    public User() {

    }

    public User(Long id, String name, String email, Double balance, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.type = type;
    }

    public User(String type, Double balance, String email, String name) {
        this.type = type;
        this.balance = balance;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
