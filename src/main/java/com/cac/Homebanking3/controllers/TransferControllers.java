package com.cac.Homebanking3.controllers;

import com.cac.Homebanking3.models.dtos.TransferDTO;
import com.cac.Homebanking3.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")

public class TransferControllers {

    @Autowired
    private final TransferService service;
    public TransferControllers(TransferService service){
        this.service=service;
    }

    @GetMapping(value="/transfer")

    public ResponseEntity<List<TransferDTO>> getTransfers(){

        List<TransferDTO> lista= service.getTransfers();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
}

    @GetMapping(value="/transfer/{id}")
    public ResponseEntity<TransferDTO>getTransferById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTransferById(id));
}

    @PostMapping(value="/transfer")

    public ResponseEntity <TransferDTO> performTransfer(@RequestBody TransferDTO dto){

     return ResponseEntity.status(HttpStatus.CREATED).body(service.performTransfer(dto));
    }

    @PutMapping(value="/transfer/{id}")
    public ResponseEntity<TransferDTO> updateTransfer(@PathVariable Long id,@RequestBody TransferDTO transfer){

        return ResponseEntity.status(HttpStatus.OK).body(service.updateTransfer(id,transfer));
    }

    @DeleteMapping(value="/transfer/{id}")
    public ResponseEntity<String> deleteTransfer(@PathVariable Long id){
      service.deleteTransfer(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
}
}