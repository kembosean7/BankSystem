package com.example.demo.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "email_unique", columnNames = "email"),
                            @UniqueConstraint(name = "account_number_unique", columnNames = "account_number")

        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "account_number", nullable = false, unique = true, length = 50)
    private String accountNumber;

    @PrePersist
    public void generateAccountNumber(){
        if(this.accountNumber == null || this.accountNumber.isEmpty()){
            this.accountNumber = generateRandomAccountNumber();
        }
    }

    private String generateRandomAccountNumber(){
        return UUID.randomUUID().toString().replace("-","").substring(0,10);
    }

    @Column(length = 100, nullable = false)
    private String first_name;

    @Column(length = 100, nullable = false)
    private String last_name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String type;

    @Column(name = "balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal balance;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    public User() {

    }

    public User(Long id, String first_name, String last_name, String email, String password, BigDecimal balance, String type) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.type = type;
    }

    public User(String type, BigDecimal balance, String email,String password, String first_name, String last_name) {
        this.type = type;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_number() {
        return accountNumber;
    }

    public void setAccount_number(String account_number) {
        this.accountNumber = account_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account_number='" + accountNumber + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}
