package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bank")
public class UserController {

    @GetMapping("/home")
    public String home(){
        return  "Welcome to the Banking Api";


    }





}
