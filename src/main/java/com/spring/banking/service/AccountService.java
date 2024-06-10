package com.spring.banking.service;

import com.spring.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long accountId);

    AccountDto deposit(Long accountId, double amount);

    AccountDto withdraw(Long accountId, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long accountId);
}
