package com.cac.Homebanking3.models.dtos;

import com.cac.Homebanking3.models.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;

    private AccountType Type;
    private String cbu;
    private String alias;
    private BigDecimal amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getType() {
        return Type;
    }

    public void setType(AccountType type) {
        Type = type;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private Date new_account_date;
    private Date mod_account_date;

    public Date getMod_account_date() {
        return mod_account_date;
    }

    public void setMod_account_date(Date mod_account_date) {
        this.mod_account_date = mod_account_date;
    }

    public Date getNew_account_date() {
        return new_account_date;
    }

    public void setNew_account_date(Date new_account_date) {
        this.new_account_date = new_account_date;
    }
}
