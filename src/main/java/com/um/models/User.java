
package com.um.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.OneToMany;

import javax.persistence.CascadeType;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @OneToMany(mappedBy="userOwner", cascade=CascadeType.ALL, orphanRemoval=true)
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<House> houses;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // @Id
    // @Column(name = "USER_ID")
    // @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getApellido() {
        return lastname;
    }

    public void setApellido(String lastname) {
        this.lastname = lastname;
    }

    public Integer getEdad() {
        return age;
    }

    public void setEdad(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}