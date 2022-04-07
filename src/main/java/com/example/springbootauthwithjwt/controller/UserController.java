package com.example.springbootauthwithjwt.controller;

import com.example.springbootauthwithjwt.entity.User;
import com.example.springbootauthwithjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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

   @PostMapping("/auth/signup")
   public User registerUser(@RequestBody User user){
      return userService.registerUser(user);
   }

   @GetMapping("/admin")
   @PreAuthorize("hasRole('Admin')")
   public String forAdmin(){
      return "This URL is only valid for admin";
   }

   @GetMapping("/user")
   @PreAuthorize("hasRole('User')")
   public String forUser(){
      return "This URL is only valid for user";
   }

   @GetMapping("/user-and-admin")
   @PreAuthorize("hasAnyRole('Admin', 'User')")
   public String forUserAndAdmin(){
      return "This URL is only for user and admin";
   }

   @GetMapping("/public")
   public String forPublic(){
      return "This URL is public";
   }
}
