package com.cac.Homebanking3.mappers;

import com.cac.Homebanking3.models.Transfer;

import com.cac.Homebanking3.models.dtos.TransferDTO;


import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {

    public static TransferDTO transferToDto(Transfer transfer) {
        TransferDTO dto = new TransferDTO();
        dto.setTarget(transfer.getTarget());
        dto.setDate(transfer.getDate());
        dto.setOrigin(transfer.getOrigin());
        dto.setAmount(transfer.getAmount());

        return dto;

    }

    public static Transfer dtoToTransfer(TransferDTO dto) {

       Transfer transfer = new Transfer();
        transfer.setId(dto.getId());
        transfer.setOrigin(dto.getOrigin());
        transfer.setAmount((dto.getAmount()));
        transfer.setTarget(dto.getTarget());
        transfer.setDate(dto.getDate());
        return transfer;

    }

}