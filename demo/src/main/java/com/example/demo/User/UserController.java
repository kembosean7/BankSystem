package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/bank/accounts")
public class UserController {

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private  final UserService userService;


    @GetMapping("/accounts")
    public List<User> getAccounts(){
        return userService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public User getAccountById(@PathVariable Long id){
        return userService.getAccountById(id);
    }

    @PostMapping
    public void registerNewAccount(@RequestBody User user){
        userService.addNewAccount(user);
    }

    @DeleteMapping(path = "/accounts/{id}")
    public void deleteAccount(@PathVariable("id") Long id){
        userService.deleteAccountById(id);
    }

    @PutMapping(path="/accounts/{id}")
    public void updateAccount(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        userService.updateAccount(id, name , email);
    }





}
