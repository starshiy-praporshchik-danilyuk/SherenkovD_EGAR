package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Role;
import com.example.sherenkovd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByLogin(String login);
    List<User> findUsersByRoleEquals(Role role);
}
