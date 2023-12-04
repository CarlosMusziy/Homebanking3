package com.cac.Homebanking3.services;



import com.cac.Homebanking3.exceptions.InsufficientFoundsException;
import com.cac.Homebanking3.exceptions.TransferNotFaundException;
import com.cac.Homebanking3.mappers.TransferMapper;


import com.cac.Homebanking3.models.Account;
import com.cac.Homebanking3.models.Transfer;


import com.cac.Homebanking3.models.dtos.TransferDTO;

import com.cac.Homebanking3.repositories.AccountRepository;
import com.cac.Homebanking3.repositories.TransferRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TransferService {

    private final TransferRepository repository;
    private final AccountRepository accountRepository;

    public TransferService(TransferRepository repository, AccountRepository accountRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;

    }

    public List<TransferDTO> getTransfers() {
        List<Transfer> transfers = repository.findAll();
        List<TransferDTO> transferDtos = transfers.stream()
                .map(TransferMapper::transferToDto)
                .collect(Collectors.toList());
        return transferDtos;
    }

    public TransferDTO getTransferById(Long id) {
        Transfer entity = repository.findById(id).orElseThrow(() -> new TransferNotFaundException("la transferencia selecionado no existe"));
        return TransferMapper.transferToDto(entity);
    }

    public TransferDTO updateTransfer(Long id, TransferDTO transferDTO) {

        Transfer transfer = repository.findById(id).orElseThrow(() -> new TransferNotFaundException("la transferencia selecionado no existe"));
        Transfer updatedTransfer = TransferMapper.dtoToTransfer(transferDTO);
        updatedTransfer.setId(transfer.getId());
        return TransferMapper.transferToDto(transfer);
    }

    public String deleteTransfer(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "se ha eliminado la transferencia";

        } else {
            return ("El usuario selecionado no existe");

        }
    }

    @Transactional

    public TransferDTO performTransfer(TransferDTO dto) {

        Account originAccount = accountRepository.findById(dto.getOrigin())
                .orElseThrow(() -> new TransferNotFaundException("La Cuenta Origen no Existe"));
        Account destinationAccount = accountRepository.findById(dto.getTarget())
                .orElseThrow(() -> new TransferNotFaundException("La Cuenta destino no Existe"));
        //compruebo fondos de cuenta origen
        if (originAccount.getAmount().compareTo(dto.getAmount()) < 0) {
            throw new InsufficientFoundsException("fondos insuficientes en la cuenta Origen");
        }
        //realizo transferencia

        originAccount.setAmount(originAccount.getAmount().subtract(dto.getAmount()));
        destinationAccount.setAmount(destinationAccount.getAmount().add(dto.getAmount()));

        //gardar las cuentas realizadas

        accountRepository.save(originAccount);
        accountRepository.save(destinationAccount);

        //creo la transferencia y guardo en BD

        Transfer transfer = new Transfer();
        Date date = new Date();

        //seteamos el objeto fecha actual en eltransferDTO
        transfer.setDate(date);
        transfer.setOrigin(originAccount.getId());
        transfer.setTarget(destinationAccount.getId());
        transfer.setAmount(dto.getAmount());
        transfer = repository.save(transfer);

        //devolver la transferencia realizada

        return TransferMapper.transferToDto(transfer);
    }
}