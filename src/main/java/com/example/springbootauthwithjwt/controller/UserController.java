package com.example.springbootauthwithjwt.controller;

import com.example.springbootauthwithjwt.entity.User;
import com.example.springbootauthwithjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

   @Autowired
   private UserService userService;

   @PostConstruct
   public void initRolesAndUser(){
      userService.initRolesAndUser();
   }

   @PostMapping("/user")
   public User registerUser(@RequestBody User user){
      return userService.registerUser(user);
   }
}