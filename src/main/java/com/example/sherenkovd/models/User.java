package com.example.sherenkovd.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    private String login;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String surname;

    @Column(length = 20)
    private String password;

    //TODO: OneToOne
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "role_idr"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;
    
    //TODO: сделать правильную развязку
    @ManyToOne
    @JoinColumn("role_id")
    Role role;

    public User() {
    }

    public User(String login, String name, String surname, String password, Set<Role> role) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }
}
