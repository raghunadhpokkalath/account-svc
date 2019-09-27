package com.anz.wd.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
public class AccountDto {
    private String accountNumber;
    private String accountName;
    private String accountType;
    private LocalDate balanceDate;
    private String currCode;
    private Double availBalance;

}
