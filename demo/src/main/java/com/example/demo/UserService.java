package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public String home(){
        return "Welcome to the Banking API";
    }

    public List<User> getAccounts(){

        return  List.of(
                new User(
                        1L,
                        "sean",
                        "kembosean7@gmail.com",
                        90.00,
                        "savings")
        );
    }



}
