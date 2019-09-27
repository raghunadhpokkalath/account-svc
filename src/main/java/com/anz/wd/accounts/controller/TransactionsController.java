package com.anz.wd.accounts.controller;

import com.anz.wd.accounts.dto.TransactionDto;
import com.anz.wd.accounts.model.Account;
import com.anz.wd.accounts.model.Transaction;
import com.anz.wd.accounts.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionsController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts/{accountNum}/transactions")
    public List<TransactionDto> getTransactions(@PathVariable String accountNum){

        List<TransactionDto> transactionList= accountService.getTransactions(accountNum);

        return transactionList;
    }

}
