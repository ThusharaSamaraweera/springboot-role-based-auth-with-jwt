package com.example.springbootauthwithjwt.repository;

import com.example.springbootauthwithjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
