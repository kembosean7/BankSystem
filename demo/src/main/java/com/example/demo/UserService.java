package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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


}
