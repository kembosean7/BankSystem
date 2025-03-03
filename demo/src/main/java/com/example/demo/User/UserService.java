package com.example.demo.User;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    public String home(){
        return "Welcome to the Banking API";
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    //Method to get all accounts from database
    public List<User> getAccounts(){

        return userRepository.findAll();

    }

    //Method to get account by ID from database
    public User getAccountById(Long id){

        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with ID " + id + " not found"));
    }

    //Method to get account by account number
    public User getAccountByAccNo(String accountId){

        return userRepository.findByAccountNumber(accountId).orElseThrow(() -> new IllegalStateException("User with account number "+ accountId + " not found"));
    }


    public void addNewAccount(User user) {

        Optional<User> accountOptional = userRepository
                .findAccountByEmail(user.getEmail());
        if (accountOptional.isPresent()){
            throw new IllegalStateException(("Email already taken"));
        }

        userRepository.save(user);
    }
    private  boolean validatPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalStateException("Password cannot be empty");
        }

        if (password.length() < 8) {
            throw new IllegalStateException("Password must be at least 8 characters long");
        }

        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }

        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }
        return true;
    }

    public void deleteAccountById(Long id) {
        boolean exist = userRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Account with ID: " + id + " does not exist");
        }

        userRepository.deleteById(id);

    }

    @Transactional
    public void updateAccount(Long id, String name, String email){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Account with ID: " + id + " does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(user.getFirst_name(), name)){
            user.setFirst_name(name);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(user.getEmail(), email)){
            Optional<User> accountOptional = userRepository.findAccountByEmail(email);
            if (accountOptional.isPresent()){
                throw new IllegalStateException("Email already taken");
            }
            user.setEmail(email);
        }

        userRepository.save(user);
    }

}
