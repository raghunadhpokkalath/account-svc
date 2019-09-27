package com.anz.wd.accounts.controller;

import com.anz.wd.accounts.dto.TransactionDto;
import com.anz.wd.accounts.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Transactions")
@RestController
public class TransactionsController {

    @Autowired
    AccountService accountService;

    @ApiOperation(value = "RetrieveTransactions", response = TransactionDto.class, notes = "This endpoint retrieve Transactions corresponding to customer id ")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Transactio retrieved"),
                    @ApiResponse(code = 400, message = "No Matching record found"),
                    @ApiResponse(code = 500, message = "Internal Server Error")
            }
    )
    @GetMapping("/accounts/{accountNum}/transactions")
    public List<TransactionDto> getTransactions(@PathVariable String accountNum) {

        List<TransactionDto> transactionList = accountService.getTransactions(accountNum);

        return transactionList;
    }

}
