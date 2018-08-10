package com.test.spring.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void transfer( String out,  String in,  Double money) {
			// 声明式事务管理
				accountDao.outMoney(out, money);
				//int i = 1 / 0;
				accountDao.inMoney(in, money);								

	}

}
