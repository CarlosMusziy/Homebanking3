package com.cac.Homebanking3.models;


import jakarta.persistence.*;

import java.util.List;

//prueba
@Entity
@Table(name="usuarios")
//@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Column(name="nombre")
    private String username;
    private String password;

    private String email;

    private String surname;

    private String update_At;

    public String getUpdate_At() {
        return update_At;
    }

    public void setUpdate_At(String update_At) {
        this.update_At = update_At;
    }

    private String dni;
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL,orphanRemoval = true)

    private List<Account> accounts;

}
