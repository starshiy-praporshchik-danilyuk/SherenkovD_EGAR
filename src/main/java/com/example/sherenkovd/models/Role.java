package com.example.sherenkovd.models;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
//TODO: переделать на Entity
public enum Role {
    STUDENT, TEACHER;

	//TOOD: перенести в сущность пользователя
    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        String name = this.name();

        authorities.add(new SimpleGrantedAuthority(name));
        return authorities;
    }
}
