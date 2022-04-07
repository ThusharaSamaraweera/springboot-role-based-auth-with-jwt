package com.example.springbootauthwithjwt.controller;

import com.example.springbootauthwithjwt.entity.JwtRequest;
import com.example.springbootauthwithjwt.entity.JwtResponse;
import com.example.springbootauthwithjwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

  @Autowired
  private JwtService jwtService;


  @PostMapping("/auth/login")
  public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
    return jwtService.createJwtToken(jwtRequest);
  }
}
