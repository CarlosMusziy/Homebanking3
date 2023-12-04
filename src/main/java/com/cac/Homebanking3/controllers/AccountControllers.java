package com.cac.Homebanking3.controllers;



import com.cac.Homebanking3.models.dtos.AccountDTO;
import com.cac.Homebanking3.models.dtos.UserDTO;
import com.cac.Homebanking3.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class AccountControllers {
    @Autowired
    private final AccountService service;

    public AccountControllers(AccountService service) {
        this.service = service;
    }

    @GetMapping(value = "/account")

    public ResponseEntity<List<AccountDTO>> getAccount() {

        List<AccountDTO> lista = service.getAccount();

        return ResponseEntity.status(HttpStatus.OK).body(lista);

        //return List.of("carlos","martin");


    }

    @PostMapping(value = "/account")
    public ResponseEntity createAccount(@RequestBody AccountDTO account) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(account));
    }

    @GetMapping(value = "/account/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccountById(id));
    }

    @DeleteMapping(value="/account/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        service.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body("La cuenta con id" +id+"ha sido eliminada");

    }
    @PutMapping(value="/account/{id}")
    public ResponseEntity<AccountDTO> upDateUser(@PathVariable Long id,@RequestBody AccountDTO account){

        return ResponseEntity.status(HttpStatus.OK).body(service.upDateAccount(id,account));
    }
}