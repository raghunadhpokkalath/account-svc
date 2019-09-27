package com.anz.wd.accounts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Transaction {

    @Id
    private Integer transID;
    private String accountName;
    private LocalDate valueDate;
    private String currCode;
    private Double transAmount;
    private String transType;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_NUMBER", nullable = false)
    private Account account;

}
