package com.anz.wd.accounts.controller

import com.anz.wd.accounts.dto.AccountDto
import com.anz.wd.accounts.exception.RecordNotFoundException
import com.anz.wd.accounts.model.Account
import com.anz.wd.accounts.service.AccountService
import spock.lang.Specification

class AccountsControllerSpec extends Specification {

    AccountService accountService;
    AccountsController controller;
    def setup(){
        accountService = Mock(AccountService)
        controller = new AccountsController(accountService:accountService)
    }

    def "Retrieves Accounts for the Customer"() {

        given:
        def customerId = "10000000"

        when:
        def accountList = controller.getAccounts(customerId)

        then:
        1*accountService.getAccounts(customerId) >> [new AccountDto(),new AccountDto()]
        accountList.size() == 2


    }


    def "No Accounts for the Customer"() {

        given:
        def customerId = "23"

        when:
        def accountList = controller.getAccounts(customerId)

        then:
        1*accountService.getAccounts(customerId) >> {throw new RecordNotFoundException("No transactions for the account")}

       thrown RecordNotFoundException.class

    }
}



