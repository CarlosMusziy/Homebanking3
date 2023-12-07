package com.cac.Homebanking3.models;

import com.cac.Homebanking3.models.enums.AccountType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="cuentas")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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



    @Column (name="account_type")
    private AccountType Type;
    private String cbu;
    private String alias;
    private BigDecimal amount;

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

    @ManyToOne
    private User owner;

}
