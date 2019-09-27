package com.anz.wd.accounts.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    private String accountNumber;
    private String accountName;
    private String accountType;
    private LocalDate balanceDate;
    private String currCode;
    private Double availBalance;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

}
