package com.app.BankingApplication.dao;

import com.app.BankingApplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {


@Query(value="select customer_customer_id from account where account_id  =?1",nativeQuery = true)
    public Integer findCustomerByAccount(Integer id);


    @Transactional
    @Modifying
    @Query(value="Update Account set accountName=?2 where accountId  =?1")
    public Integer updateAccount(Integer id,String accountName);
}
