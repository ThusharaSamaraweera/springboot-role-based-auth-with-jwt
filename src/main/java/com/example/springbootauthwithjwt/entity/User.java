package com.example.springbootauthwithjwt.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String username;
  private String firstName;
  private String lastName;
  private String password;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRole() {
    return role;
  }

  public void setRole(Set<Role> role) {
    this.role = role;
  }

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "USER_ROLE",
    joinColumns = {
          @JoinColumn(name = "USER_ID")
    },
    inverseJoinColumns = {
          @JoinColumn(name = "ROLE_ID")
    }
  )
  private Set<Role> role;
}
