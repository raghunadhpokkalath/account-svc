package com.anz.wd.accounts.service

import com.anz.wd.accounts.dto.AccountDto
import com.anz.wd.accounts.dto.TransactionDto
import com.anz.wd.accounts.exception.RecordNotFoundException
import com.anz.wd.accounts.model.Account
import com.anz.wd.accounts.model.Customer
import com.anz.wd.accounts.model.Transaction
import com.anz.wd.accounts.repository.AccountRepository
import com.anz.wd.accounts.repository.TransactionRepository
import org.modelmapper.ModelMapper
import spock.lang.Specification

import java.time.LocalDate

class AccountServiceImplSpec extends Specification {
    def accountRepository
    def transactionRepository
    def modelMapper
    def AccountServiceImpl accountServiceImpl

    def setup() {
        accountRepository = Mock(AccountRepository)
        transactionRepository = Mock(TransactionRepository)
        modelMapper = Mock(ModelMapper)
        accountServiceImpl = new AccountServiceImpl(accountRepository: accountRepository, transactionRepository: transactionRepository, modelMapper: modelMapper)
    }


    def "Retrieves Account for the customer id "() {
        given:
        def custId = "5678678792"
        def acctNum = "3456690"
        def acctType = "Savings"
        def balanceDt = new LocalDate(2012, 9, 17)
        def currCde = "SGD"
        def availBal = 84899.23
        def acctName = "SGSavings78"
        Customer cust = new Customer(customerId: custId, customerName: "Test")
        Account account = new Account(accountNumber: acctNum, accountName: acctName, accountType: acctType, balanceDate: balanceDt, currCode: currCde, availBalance: availBal, customer: cust)
        AccountDto accountDto = new AccountDto(accountNumber: acctNum, accountName: acctName, accountType: acctType, balanceDate: balanceDt, currCode: currCde, availBalance: availBal)

        when:
        def accountResult = accountServiceImpl.getAccounts(custId)

        then:
        1 * accountRepository.findByCustomerCustomerId(custId) >> [account]
        1 * modelMapper.map(account, AccountDto.class) >> accountDto
        accountResult == [accountDto]

        accountDto.getAccountNumber() == account.getAccountNumber()
        accountDto.getCurrCode() == account.getCurrCode()
        accountDto.getAccountName() == account.getAccountName()
        accountDto.getAvailBalance() == account.getAvailBalance()
        accountDto.getAccountType() == account.getAccountType()
        accountDto.getBalanceDate() == account.getBalanceDate()
        account.getCustomer().getCustomerId()!=null
        account.getCustomer().getCustomerName()!=null

    }

    def "No Account for the customer id  "() {
        given:
        def custId = "5678678792"
        when:
        def accountResult = accountServiceImpl.getAccounts(custId)
        then:
        1 * accountRepository.findByCustomerCustomerId(custId) >> []
        thrown RecordNotFoundException.class

    }

    def "Retrieves Transactions  for the account "() {
        given:
        def acctNum = "3456690"
        def acctName = "Savings Account"
        def valDate = new LocalDate(2010, 8, 15)
        def currCde = "SGD"
        def tranAmt = 84899.23
        def tranType = "Credit"
        def acctType = "Savings"
        def balanceDt = new LocalDate(2012, 9, 17)
        def availBal = 84899.23
        Account accnt = new Account(accountNumber: acctNum, accountName: acctName, accountType: acctType, balanceDate: balanceDt, currCode: currCde, availBalance: availBal)
        Transaction transaction = new Transaction(transID: 12121, accountName: acctName, valueDate: valDate, currCode: currCde, transAmount: tranAmt, transType: tranType, account: accnt)
        TransactionDto transactionDto = new TransactionDto(accountName: acctName, valueDate: valDate, currCode: currCde, transAmount: tranAmt, transType: tranType,accountNumber:acctNum)

        when:
        def trasList = accountServiceImpl.getTransactions(acctNum)

        then:
        1 * transactionRepository.findByAccountAccountNumber(acctNum) >> [transaction]
        1 * modelMapper.map(transaction, TransactionDto.class) >> transactionDto
        trasList == [transactionDto]
        transactionDto.getAccountName() == transaction.getAccountName()
        transactionDto.getCurrCode() == transaction.getCurrCode()
        transactionDto.getTransAmount() == transaction.getTransAmount()
        transactionDto.getTransType() == transaction.getTransType()
        transactionDto.getValueDate() == transaction.getValueDate()
        transactionDto.getAccountNumber() == transaction.getAccount().getAccountNumber()
        transaction.getTransID() != null
    }

    def "No  Transactions  for the account "() {
        given:
        def acctNum = "3456690"

        when:
        def trasList = accountServiceImpl.getTransactions(acctNum)

        then:
        1 * transactionRepository.findByAccountAccountNumber(acctNum) >> []
        thrown RecordNotFoundException.class

    }
}
