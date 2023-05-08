package com.app.BankingApplication.dto;

import com.app.BankingApplication.entity.Account;
import lombok.Data;

import java.util.List;

@Data
public class CustomerResponse {
    private Integer customerId;
    private String customerName;
}
