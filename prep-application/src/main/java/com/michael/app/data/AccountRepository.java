package com.michael.app.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michael.app.beans.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	//List<Account> findByName(String name);
	//Account findByAccountId(Long Id);
	Account findByUsernameAndPassword(String username, String password);

}
