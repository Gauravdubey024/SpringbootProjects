package com.app.BankingApplication;

import com.app.BankingApplication.dao.AccountRepo;
import com.app.BankingApplication.dao.CustomerRepo;
import com.app.BankingApplication.entity.Account;
import com.app.BankingApplication.entity.Customer;
import com.app.BankingApplication.service.BankService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class BankingApplicationTests {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	AccountRepo accountrepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void addCustomerTest()
		{
			//when(customerRepo.save(c)).thenReturn(c);
			Customer c1=new Customer(0,"Gaurav", null);
			Customer a = customerRepo.save(c1);
			assertNotNull(a);
			assertEquals("Gaurav", a.getCustomerName());
			assertEquals(null, a.getAccounts());
			customerRepo.deleteById(a.getCustomerId());

			}
	@Test
	public void deleteCustomerTest( )
	{
		boolean isDeleted=false;
		Customer a=customerRepo.save(new Customer(10,"Gaurav",null));
		assertNotNull(a);
		assertEquals("Gaurav",customerRepo.findById(a.getCustomerId()).get().getCustomerName());
		customerRepo.deleteById(a.getCustomerId());
		assertEquals(true,customerRepo.findById(a.getCustomerId()).isEmpty());

	}
	@Test
	public void findCustomerTest()
	{

		Customer a= customerRepo.save(new Customer(10,"Gaurav",null));
		assertNotNull(a);
		assertEquals("Gaurav",customerRepo.findById(a.getCustomerId()).get().getCustomerName());
		customerRepo.deleteById(a.getCustomerId());
		assertEquals(true,customerRepo.findById(a.getCustomerId()).isEmpty());
	}

	@Test
	public void updateCustomerTest( )
	{
		Customer a=customerRepo.save(new Customer(10,"Gaurav",null));
		assertNotNull(a);
		assertEquals(customerRepo.findById(a.getCustomerId()).get().getCustomerName(),"Gaurav");
		customerRepo.updateCustomer(a.getCustomerId(),"Saurabh");
		assertEquals(customerRepo.findById(a.getCustomerId()).get().getCustomerName(),"Saurabh");
		customerRepo.deleteById(a.getCustomerId());
		assertEquals(true,customerRepo.findById(a.getCustomerId()).isEmpty());
	}

	@Test
	public void addAccountTest()
	{
		Account a=accountrepo.save(new Account(0,"Saving", null));
		assertNotNull(a);
		assertEquals("Saving", a.getAccountName());
		accountrepo.deleteById(a.getAccountId());
		assertEquals(true,accountrepo.findById(a.getAccountId()).isEmpty());

	}
		@Test
		public void findAccountTest()
		{

			Account a= accountrepo.save(new Account(10,"Saving",null));
			assertNotNull(a);
			assertEquals("Saving",accountrepo.findById(a.getAccountId()).get().getAccountName());
			accountrepo.deleteById(a.getAccountId());

		}

		@Test
		public void deleteAccountTest( )
		{
			boolean isDeleted=false;
			Account a=accountrepo.save(new Account(10,"Saving",null));
			assertNotNull(a);
			assertEquals("Saving",accountrepo.findById(a.getAccountId()).get().getAccountName());
			accountrepo.deleteById(a.getAccountId());
			assertEquals(true,accountrepo.findById(a.getAccountId()).isEmpty());

		}
		@Test
		public void updateAccountTest( )
		{
			Account a=accountrepo.save(new Account(10,"Saving",null));
			assertNotNull(a);
			assertEquals(accountrepo.findById(a.getAccountId()).get().getAccountName(),"Saving");

			Integer b= accountrepo.updateAccount(a.getAccountId(),"Current");

			assertEquals(accountrepo.findById(a.getAccountId()).get().getAccountName(),"Current");
			accountrepo.deleteById(a.getAccountId());
			}


		}




