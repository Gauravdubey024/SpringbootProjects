package com.app.BankingApplication.service;

import com.app.BankingApplication.dao.AccountRepo;
import com.app.BankingApplication.dao.CustomerRepo;
import com.app.BankingApplication.entity.Account;
import com.app.BankingApplication.entity.Customer;
import com.app.BankingApplication.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService{

    @Autowired
    AccountRepo acoountRepo;
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer c) {
        return customerRepo.save(c);
    }

    @Override
    public Customer getCustomerById(int id) throws BankingException {
        Customer c = customerRepo.findById(id).get();
        if(c.getCustomerId().equals(null)){
            throw new BankingException("ID does Not Exist:");
        }else{
            return c;
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws BankingException {
         List<Customer> list = customerRepo.findAll();
         if(list.isEmpty()){
             throw new BankingException("No Customer Found!!!!");
         }else{
             return list;
         }
    }
    @Override
    public Integer findCustomerByAccount(int id) throws BankingException {
        if(acoountRepo.findById(id).isEmpty()){
            throw new BankingException("No Account found!!");
        }else{
            return acoountRepo.findCustomerByAccount(id);
        }
    }

    @Override
    public void deleteCustomer(int id) throws BankingException {
        if(customerRepo.findById(id).isEmpty()){
            throw new BankingException("ID does not exist !!!");
        }else {
            customerRepo.deleteById(id);
        }
    }
    @Override
    public Integer updateCustomerById(int id, String name) throws BankingException {
        if(customerRepo.findById(id).isEmpty()){
            throw new BankingException("No Customer found!!");
        }else{
            return customerRepo.updateCustomer(id,name);
        }
    }

    @Override
    public Account addAccount(Account a) {
        return acoountRepo.save(a);
    }

    @Override
    public Account getAccountById(int id) throws BankingException {
        if(acoountRepo.findById(id).isEmpty()){
            throw new BankingException("No Account found!!");
        }else{
            return acoountRepo.findById(id).get();
        }
    }

    @Override
    public List<Account> getAccounts(int id) {
        //return acoountRepo.findAll();
        List<Account> accounts =customerRepo.findById(id).get().getAccounts();
        return accounts;
    }

    @Override
    public boolean deleteAccountById(int id) throws BankingException {

         acoountRepo.deleteById(id);
        if(acoountRepo.findById(id).isEmpty()){
            return true;
        }else{
            throw new BankingException("Account cannot be deleted");
        }
    }

    @Override
    public Integer updateAccountById(int id, String name) throws BankingException {
        if(acoountRepo.findById(id).isEmpty()){
            throw new BankingException("No Account found!!");
        }else{
            return acoountRepo.updateAccount(id,name);
        }
    }
}
