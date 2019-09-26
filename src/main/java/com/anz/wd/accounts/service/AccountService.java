package com.anz.wd.accounts.service;

import com.anz.wd.accounts.dto.AccountDto;
import com.anz.wd.accounts.dto.TransactionDto;
import com.anz.wd.accounts.model.Account;
import com.anz.wd.accounts.model.Transaction;

import java.util.List;

public interface AccountService {
    /*This will retrieve the accounts corresponding to customerid*/
    List<AccountDto> getAccounts(String custID);

    /*This will retrieve the transactions details for the account*/
    List<TransactionDto> getTransactions(String accountNum);

}
