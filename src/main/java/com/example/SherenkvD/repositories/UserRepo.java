package com.example.SherenkvD.repositories;

import com.example.SherenkvD.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
