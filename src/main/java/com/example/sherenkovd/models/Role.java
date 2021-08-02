package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Data
public class Role implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(length = 20, name = "role_name")
    private String roleName;


    public Role() {}

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
