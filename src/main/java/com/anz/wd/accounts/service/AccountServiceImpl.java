package com.anz.wd.accounts.service;

import com.anz.wd.accounts.dto.AccountDto;
import com.anz.wd.accounts.dto.TransactionDto;
import com.anz.wd.accounts.exception.RecordNotFoundException;
import com.anz.wd.accounts.model.Account;
import com.anz.wd.accounts.model.Transaction;
import com.anz.wd.accounts.repository.AccountRepository;
import com.anz.wd.accounts.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<AccountDto> getAccounts(String custID) {

        List<Account> accountList = accountRepository.findByCustomerCustomerId(custID);
        if (!accountList.isEmpty()){
           return accountList.stream().map(account -> modelMapper.map(account,AccountDto.class)).collect(Collectors.toList());
        }

       throw new RecordNotFoundException("No accounts for the customer");
    }

    @Override
    public List<TransactionDto> getTransactions(String  accountNum) {

        List<Transaction> transactionList = transactionRepository.findByAccountAccountNumber(accountNum);

        if (!transactionList.isEmpty()){
            return transactionList.stream().map(transaction -> modelMapper.map(transaction,TransactionDto.class)).collect(Collectors.toList());
        }
        throw new RecordNotFoundException("No transactions for the account");
    }
}
