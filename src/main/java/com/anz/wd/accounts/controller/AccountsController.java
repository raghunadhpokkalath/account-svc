package com.anz.wd.accounts.controller;

import com.anz.wd.accounts.dto.AccountDto;
import com.anz.wd.accounts.model.Account;
import com.anz.wd.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountsController {

    @Autowired
    AccountService accountService;


    @GetMapping("/customers/{customerId}/accounts")
    public List<AccountDto> getAccounts(@PathVariable String customerId){

       return accountService.getAccounts(customerId);
    }

}
