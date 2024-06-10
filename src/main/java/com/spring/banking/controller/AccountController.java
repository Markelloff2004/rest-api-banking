package com.spring.banking.controller;

import com.spring.banking.dto.AccountDto;
import com.spring.banking.mapper.AccountMapper;
import com.spring.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account REST API
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long accountId){
        AccountDto accountDto = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit REST API
    @PutMapping("{accountId}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long accountId,
                                              @RequestBody Map<String, Double> request){
        AccountDto accountDto = accountService.deposit(accountId, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw REST API
    @PutMapping("{accountId}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long accountId,
                                               @RequestBody Map<String, Double> request){
        AccountDto accountDto = accountService.withdraw(accountId, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    //Get All REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtoList = accountService.getAllAccounts();

        return ResponseEntity.ok(accountDtoList);
    }

    //Delete REST API
    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Account is deleted successfully");
    }
}
