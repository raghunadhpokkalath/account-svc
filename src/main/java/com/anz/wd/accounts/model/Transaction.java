package com.anz.wd.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Transaction {

    @Id
    private Integer transID;
    private String accountName;
    private Date valueDate;
    private String currCode;
    private Double transAmount;
    private String transType;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_NUMBER", nullable = false)
    private Account account;

}
