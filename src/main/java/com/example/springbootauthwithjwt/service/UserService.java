package com.example.springbootauthwithjwt.service;

import com.example.springbootauthwithjwt.entity.Role;
import com.example.springbootauthwithjwt.entity.User;
import com.example.springbootauthwithjwt.repository.RoleRepository;
import com.example.springbootauthwithjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    Role role = roleRepository.findById("User").get();

    Set<Role> roles = new HashSet<>();
    roles.add(role);
    user.setRole(roles);

    user.setPassword(getEnderedPassword(user.getPassword()));
    return userRepository.save(user);
  }

  @Autowired
  public PasswordEncoder passwordEncoder;

  public void initRolesAndUser(){
    Role adminRole = new Role();
    adminRole.setRoleName("Admin");
    adminRole.setRoleDescription("Admin role");
    roleRepository.save(adminRole);

    Role userRole = new Role();
    userRole.setRoleName("User");
    userRole.setRoleDescription("User role");
    roleRepository.save(userRole);

    User adminUser = new User();
    adminUser.setUsername("admin1");
    adminUser.setFirstName("admin");
    adminUser.setLastName("admin");
    adminUser.setPassword(getEnderedPassword("admin123"));
    Set<Role> adminRoles = new HashSet<>();
    adminRoles.add(adminRole);
    adminUser.setRole(adminRoles);
    userRepository.save(adminUser);
  }

  public String getEnderedPassword(String password){
    return passwordEncoder.encode(password);
  }
}
