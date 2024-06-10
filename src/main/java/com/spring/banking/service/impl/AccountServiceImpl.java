package com.spring.banking.service.impl;

import com.spring.banking.dto.AccountDto;
import com.spring.banking.entity.Account;
import com.spring.banking.mapper.AccountMapper;
import com.spring.banking.repository.AccountRepository;
import com.spring.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Account account = accountRepository.
                findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long accountId, double amount) {
        Account account = accountRepository.
                findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account doesn't exist"));

        double totalBalance = account.getAccountBalance() + amount;
        account.setAccountBalance(totalBalance);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long accountId, double amount) {
        Account account = accountRepository.
                findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account doesn't exist"));

        if (account.getAccountBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }

        double totalBalance = account.getAccountBalance() - amount;
        account.setAccountBalance(totalBalance);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountRepository.
                findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account doesn't exist"));

        accountRepository.delete(account);
    }
}
