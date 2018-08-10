package com.test.spring.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


/**
 *@Transational注解中的属性： 
 * propagation	:事务的传播行为
 * isolation	:事务的隔离级别
 * readOnly		:只读
 * rollbackFor	:发生哪些异常回滚
 * noRollbackFor:发生哪些异常不回滚
 */
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void transfer( String out,  String in,  Double money) {
			// 声明式事务管理
				accountDao.outMoney(out, money);
				int i = 1 / 0;
				accountDao.inMoney(in, money);								

	}

}
