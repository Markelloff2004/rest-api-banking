package com.spring.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long account_id;
    private String accountHolderName;
    private double accountBalance;
}
