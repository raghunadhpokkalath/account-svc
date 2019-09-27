package com.anz.wd.accounts.dto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
public class TransactionDto {
    private String accountName;
    private LocalDate valueDate;
    private String currCode;
    private Double transAmount;
    private String transType;
    private String accountNumber;
}
