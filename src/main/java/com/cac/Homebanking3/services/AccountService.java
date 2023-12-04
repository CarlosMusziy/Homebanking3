package com.cac.Homebanking3.services;


import com.cac.Homebanking3.exceptions.AccountNotExistsException;
import com.cac.Homebanking3.mappers.AccountMapper;
import com.cac.Homebanking3.models.Account;
import com.cac.Homebanking3.models.dtos.AccountDTO;
import com.cac.Homebanking3.models.enums.AccountType;
import com.cac.Homebanking3.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;
    public List<AccountDTO> getAccount() {
            List<Account> account = repository.findAll();
            List<AccountDTO> accountDtos = account.stream()
                    .map(AccountMapper::accountToDto)
                    .collect(Collectors.toList());
            return accountDtos;


    }

    public AccountDTO createAccount(AccountDTO account) {
            account.setType(AccountType.SAVINGS_BANK);
           // account.setAmount(BigDecimal.ZERO);
            Account accountSaved = repository.save(AccountMapper.dtoToAccount(account));
            return AccountMapper.accountToDto(accountSaved);}

    public AccountDTO getAccountById(Long id) {
        Account entity = repository.findById(id).get();
        return AccountMapper.accountToDto(entity);
    }

    public void deleteAccount(Long id) {

            if (getAccountById(id) != null) {
                repository.deleteById(id);
            } else {
                throw new AccountNotExistsException("El usuario selecionado no existe");


        }
    }

    public AccountDTO upDateAccount(Long id, AccountDTO account) {

        
            Account accountToModify =repository.findById(id).get();
            if (repository.existsById(id)) {
                if(account.getAmount() !=null){accountToModify.setAmount(account.getAmount());}
                if(account.getCbu() !=null){accountToModify.setCbu(account.getCbu());}
                if(account.getAlias() !=null){accountToModify.setAlias(account.getAlias());}
                if(account.getAmount()!=null){accountToModify.setAmount(account.getAmount());}
                if(account.getType()!=null){accountToModify.setType(account.getType());}

                Account accountModified= repository.save(accountToModify);

                return AccountMapper.accountToDto(accountModified);

            }
            return null;
    }
}

