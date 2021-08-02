package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @Column(length = 20, name = "login")
    private String login;

    @Column(length = 20, name = "name")
    private String name;

    @Column(length = 20, name = "surname")
    private String surname;

    @Column(length = 20, name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public User(String login, String name, String surname, String password, Role role) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }
}
