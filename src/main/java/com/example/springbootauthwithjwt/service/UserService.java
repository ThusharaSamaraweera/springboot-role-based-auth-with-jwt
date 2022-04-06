package com.example.springbootauthwithjwt.service;

import com.example.springbootauthwithjwt.entity.Role;
import com.example.springbootauthwithjwt.entity.User;
import com.example.springbootauthwithjwt.repository.RoleRepository;
import com.example.springbootauthwithjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  public User registerUser(User user){
    return userRepository.save(user);
  }

  public void initRolesAndUser(){
    Role adminRole = new Role();
    adminRole.setRoleName("Admin");
    adminRole.setRoleDescription("Admin role");
    roleRepository.save(adminRole);

    Role userRole = new Role();
    userRole.setRoleName("user");
    userRole.setRoleDescription("User role");
    roleRepository.save(userRole);

    User adminUser = new User();
    adminUser.setId(1);
    adminUser.setUsername("admin1");
    adminUser.setFirstName("admin");
    adminUser.setLastName("admin");
    adminUser.setPassword("admin123");
    Set<Role> adminRoles = new HashSet<>();
    adminRoles.add(adminRole);
    adminUser.setRole(adminRoles);
    userRepository.save(adminUser);
  }
}
