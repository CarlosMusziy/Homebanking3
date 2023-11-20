package com.cac.Homebanking3.controllers;





import com.cac.Homebanking3.models.dtos.UserDTO;
import com.cac.Homebanking3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//defino que la clase es un controlados
@RestController
@RequestMapping(value="/api")

public class UserControllers {


//instancio al Service (UserService) inyectando dependencias
    @Autowired
    private final UserService service;
    public UserControllers(UserService service){
        this.service=service;
    }

    @GetMapping(value="/users")

    public ResponseEntity<List<UserDTO>> getUsers(){

        List<UserDTO> lista= service.getUsers();

        return ResponseEntity.status(HttpStatus.OK).body(lista);

       //return List.of("carlos","martin");



    }
    @GetMapping(value="/users/{id}")
    public ResponseEntity<UserDTO>getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));

    }


    public void upDateAllUsers(){}
    public void upDateUser(){}
    @PostMapping(value="/users")
    public ResponseEntity createUser(@RequestBody UserDTO user){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }
    public void deleteUser(){}

}
