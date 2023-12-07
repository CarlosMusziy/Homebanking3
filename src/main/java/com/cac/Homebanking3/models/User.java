package com.cac.Homebanking3.models;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;
import java.util.List;

//prueba
@Entity
@Table(name="usuarios")
@Builder
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

    private String dni;

    private Date new_user_date;

    public Date getNew_user_date() {
        return new_user_date;
    }

    public void setNew_user_date(Date new_user_date) {
        this.new_user_date = new_user_date;
    }

    public Date getMod_user_date() {
        return mod_user_date;
    }

    public void setMod_user_date(Date mod_user_date) {
        this.mod_user_date = mod_user_date;
    }

    private Date mod_user_date;

   @OneToMany(mappedBy = "ownwer",cascade = CascadeType.ALL,orphanRemoval = true)

    private List<Account> accounts;
}
