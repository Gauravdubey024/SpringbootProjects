package com.app.BankingApplication.dto;

import com.app.BankingApplication.entity.Customer;
import lombok.Data;

@Data
public class AccountResponse {
    private Integer accountId;
    private String accountName;
    private Customer customer;
}
