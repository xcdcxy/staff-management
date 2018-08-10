package com.test.spring.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class AccountServiceImpl implements AccountService {

	// 注入事务管理的模板
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void transfer(final String out, final String in, final Double money) {
		// 编程式事务管理
		// 备注： 匿名内部类要使用外部方法的形参必须用final修饰
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				accountDao.outMoney(out, money);
				int i = 1 / 0;
				accountDao.inMoney(in, money);								
			}
		});
		
		
	}

}
