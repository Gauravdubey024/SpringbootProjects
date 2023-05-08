package com.app.BankingApplication.dao;

import com.app.BankingApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    @Transactional
    @Modifying
    @Query(value="Update Customer set customerName=?2 where customerId  =?1")
    public Integer updateCustomer(Integer id,String Name);
}
