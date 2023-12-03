package com.cac.Homebanking3.mappers;

import com.cac.Homebanking3.models.Account;

import com.cac.Homebanking3.models.dtos.AccountDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    public static AccountDTO accountToDto(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setAlias(account.getAlias());
        dto.setCbu(account.getCbu());
        dto.setAmount((account.getAmount()));
        dto.setType(account.getType());
        dto.setId(account.getId());
        return dto;

    }

    public static Account dtoToAccount(AccountDTO dto) {

        Account account = new Account();
        account.setAlias(dto.getAlias());
        account.setCbu(dto.getCbu());
        account.setAmount((dto.getAmount()));
        account.setType(dto.getType());
        return account;

    }
}