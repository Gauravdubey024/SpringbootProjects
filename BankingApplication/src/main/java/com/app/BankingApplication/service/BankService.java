package com.app.BankingApplication.service;
import com.app.BankingApplication.entity.Account;
import com.app.BankingApplication.entity.Customer;
import com.app.BankingApplication.exception.BankingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {

    public Customer addCustomer(Customer c);

    public Customer getCustomerById(int id) throws BankingException;

    public List<Customer> getAllCustomers() throws BankingException;

    Integer findCustomerByAccount(int id) throws BankingException;

    public void deleteCustomer(int id) throws BankingException;

    Integer updateCustomerById(int id, String name) throws BankingException;

    public Account addAccount(Account a);
    public Account getAccountById(int id) throws BankingException;

    public List<Account> getAccounts(int id);
    public boolean deleteAccountById(int id) throws BankingException;

    Integer updateAccountById(int id, String name) throws BankingException;
}
