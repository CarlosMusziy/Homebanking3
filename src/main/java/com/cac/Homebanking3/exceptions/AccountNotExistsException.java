package com.cac.Homebanking3.exceptions;

public class AccountNotExistsException extends RuntimeException {
    public AccountNotExistsException(String message) {
        super(message);
    }
}