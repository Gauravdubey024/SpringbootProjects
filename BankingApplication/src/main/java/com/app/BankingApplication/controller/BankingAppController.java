package com.app.BankingApplication.controller;

import com.app.BankingApplication.dao.AccountRepo;
import com.app.BankingApplication.dao.CustomerRepo;
import com.app.BankingApplication.dto.AccountResponse;
import com.app.BankingApplication.entity.Account;
import com.app.BankingApplication.entity.Customer;
import com.app.BankingApplication.exception.BankingException;
import com.app.BankingApplication.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankingAppController {

    @Autowired
    BankService bankService;


    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
        return new ResponseEntity<Customer>(bankService.addCustomer(c), HttpStatus.CREATED);
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        try {
            return bankService.getCustomerById(id);
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        try {
            return bankService.getAllCustomers();
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/customer/{id}")
    public Integer updateCustomer(@PathVariable Integer id,@RequestBody Customer c){
        try {
            return bankService.updateCustomerById(id,c.getCustomerName());
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable int id){
        try {
            bankService.deleteCustomer(id);
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account a){

        return bankService.addAccount(a);
    }
    @GetMapping("/account/{id}")
    public AccountResponse addCustomer(@PathVariable Integer id){

        Integer customer_id = null;
        try {
            customer_id = bankService.findCustomerByAccount(id);
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
        Account a1 = null;
        try {
            a1 = bankService.getAccountById(id);
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
        Customer c = null;
        try {
            c = bankService.getCustomerById(customer_id);
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
        AccountResponse a = new AccountResponse();
            a.setCustomer(c);
            a.setAccountId(a1.getAccountId());
            a.setAccountName(a1.getAccountName());
            return a;

    }
    @GetMapping("/{id}/accounts")
    public List<Account> getAccounts(@PathVariable Integer id){
        return bankService.getAccounts(id);
    }

    @DeleteMapping("/account/{id}")
    public boolean deleteAccount(@PathVariable int id){
        try {
            return bankService.deleteAccountById(id);
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/account/{id}")
    public Integer updateCustomer(@PathVariable Integer id,@RequestBody Account name){
        try {
            return bankService.updateAccountById(id,name.getAccountName());
        } catch (BankingException e) {
            throw new RuntimeException(e);
        }
    }
}
