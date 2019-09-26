package com.anz.wd.accounts.repository;

import com.anz.wd.accounts.model.Account;
import com.anz.wd.accounts.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository  extends CrudRepository<Transaction,String> {

    List<Transaction> findByAccountAccountNumber(String accountNumber);
}
