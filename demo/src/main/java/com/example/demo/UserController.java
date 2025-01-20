package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bank")
public class UserController {

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private  final UserService userService;

    @GetMapping("/home")
    public String home(){
        return userService.home();

    }


    @GetMapping("/accounts")
    public List<User> getAccounts(){
        return userService.getAccounts();


    }




}
