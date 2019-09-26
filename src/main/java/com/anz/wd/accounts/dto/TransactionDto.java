package com.anz.wd.accounts.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class TransactionDto {
    private String accountName;
    private Date valueDate;
    private String currCode;
    private Double transAmount;
    private String transType;
    private String accountNumber;
}
