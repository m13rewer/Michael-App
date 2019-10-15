package com.michael.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.michael.app.beans.Account;
import com.michael.app.data.AccountRepository;

@Service
@Transactional(readOnly=true)
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository ar;
	
	public Account getAccount(Long id) {
		return ar.getOne(id);
	}
	
	public Account login(@Param("user") String username, @Param("pass") String password) {
		return ar.findByUsernameAndPassword(username, password);
	}

	public List<Account> getAll() {
		return ar.findAll();
	}

	@Transactional(readOnly=false)
	public void saveAccount(Account account) {
		ar.save(account);
	}

	@Transactional(readOnly=false)
	public void deleteAccount(Account account) {
		ar.delete(account);
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void createAccount() throws Exception {
		//Origin o = new Origin();
		//o.setId(1);
		//o.setName("Mario Bros.");
		
//		Tier t = new Tier();
//		t.setName("Mid");
//		System.out.println("Before we call Tier service method");
//		ts.saveTier(t);
//		System.out.println("After we call Tier service method");
		
		Account a = new Account();
//		System.out.println("Before we call Origin service method");
//		os.saveOrigin(o);
//		System.out.println("After we call Origin service method");
		
//		a.setUsername(ts.getTier(t.getId()));
//		a.setOrigin(os.getOrigin(o.getId()));
		
		//ar.save(a);
	}
	
	@Transactional(readOnly=false)
	public void updateAccount() {
		// TODO Auto-generated method stub
		
	}

}
