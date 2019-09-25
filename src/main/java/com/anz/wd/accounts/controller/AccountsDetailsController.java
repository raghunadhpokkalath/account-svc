package com.anz.wd.accounts.controller;

import com.anz.wd.accounts.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountsDetailsController {

    @GetMapping("/accounts/{id}/transcations")
    public List<Account> getAccounts(@PathVariable String id){

        List<Account> accountList = new ArrayList();
        Account data = new Account();
        data.setAccountNumber(12121);
        accountList.add(data);
        return accountList;
    }

}
