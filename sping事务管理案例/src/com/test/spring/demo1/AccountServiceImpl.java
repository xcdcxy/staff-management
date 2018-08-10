package com.test.spring.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class AccountServiceImpl implements AccountService {

	// ע����������ģ��
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void transfer(final String out, final String in, final Double money) {
		// ���ʽ�������
		// ��ע�� �����ڲ���Ҫʹ���ⲿ�������βα�����final����
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
