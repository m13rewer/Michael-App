package com.michael.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michael.app.beans.Account;

@Service
public interface AccountService {
	Account getAccount(Long id);
	List<Account> getAll();
	void saveAccount(Account a);
	void deleteAccount(Account a);
	Account login(String username, String password);
	public void createAccount() throws Exception;
	public void updateAccount();
}
