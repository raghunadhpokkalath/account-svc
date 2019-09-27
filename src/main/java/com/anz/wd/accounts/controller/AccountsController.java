package com.anz.wd.accounts.controller;

import com.anz.wd.accounts.dto.AccountDto;
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

@Api(value = "Accounts Retrieval")
@RestController
public class AccountsController {

    @Autowired
    AccountService accountService;


    @GetMapping("/customers/{customerId}/accounts")
    @ApiOperation(value = "RetrieveAccounts" , response = AccountDto.class,notes="This endpoint retrieve accounts corresponding to customer id ")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Accounts retrieved"),
                    @ApiResponse(code = 400, message = "No Matching record found"),
                    @ApiResponse(code = 500, message = "Internal Server Error")
            }
    )
    public List<AccountDto> getAccounts(@PathVariable String customerId){

       return accountService.getAccounts(customerId);
    }

}
