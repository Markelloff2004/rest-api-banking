package com.spring.banking.mapper;

import com.spring.banking.dto.AccountDto;
import com.spring.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getAccount_id(),
                accountDto.getAccountHolderName(),
                accountDto.getAccountBalance()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getAccountId(),
                account.getAccountHolderName(),
                account.getAccountBalance()
        );

        return accountDto;
    }
}
