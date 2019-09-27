package com.anz.wd.accounts.controller
import com.anz.wd.accounts.dto.TransactionDto
import com.anz.wd.accounts.service.AccountService
import spock.lang.Specification

class TransactionsControllerSpec extends Specification {

    AccountService accountService
    TransactionsController controller

    def setup(){

        accountService = Mock(AccountService)
        controller = new TransactionsController(accountService:accountService)
    }

    def "Retrieves Transactions for the Account"() {

        given:
        def accountNumber = "5678678792"

        when:
        def transList = controller.getTransactions(accountNumber)

        then:
        1*accountService.getTransactions(accountNumber) >> [new TransactionDto(), new TransactionDto()]
        transList.size() == 2

    }
}
