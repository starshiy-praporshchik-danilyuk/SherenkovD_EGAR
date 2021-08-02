package com.example.sherenkovd.service;

import com.example.sherenkovd.models.Role;
import com.example.sherenkovd.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role getRole(int id){
        return roleRepo.getById(id);
    }
}
