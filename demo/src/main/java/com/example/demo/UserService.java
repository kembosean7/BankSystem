package com.example.demo;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public List<User> getAccounts(){

        return userRepository.findAll();

    }

    public User getAccountById(Long id){

        return userRepository.findById(id).orElse(null);
    }


    public void addNewAccount(User user) {

        Optional<User> accountOptional = userRepository
                .findAccountByEmail(user.getEmail());
        if (accountOptional.isPresent()){
            throw new IllegalStateException(("Email already taken"));
        }
        userRepository.save(user);
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
