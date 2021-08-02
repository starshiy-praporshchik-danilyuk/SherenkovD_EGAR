package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
