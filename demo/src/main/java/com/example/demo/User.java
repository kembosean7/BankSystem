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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String first_name;
    private String email;
    private Double balance;
    private String type;

    public User() {

    }

    public User(Long id, String first_name, String email, Double balance, String type) {
        this.id = id;
        this.first_name = first_name;
        this.email = email;
        this.balance = balance;
        this.type = type;
    }

    public User(String type, Double balance, String email, String first_name) {
        this.type = type;
        this.balance = balance;
        this.email = email;
        this.first_name = first_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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
                ", name='" + first_name+ '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
