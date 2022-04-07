package com.example.springbootauthwithjwt.service;

import com.example.springbootauthwithjwt.entity.Role;
import com.example.springbootauthwithjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;

  public Role createRole(Role role){
    return roleRepository.save(role);
  }
}
