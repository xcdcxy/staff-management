package com.test.spring.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


/**
 *@Transationalע���е����ԣ� 
 * propagation	:����Ĵ�����Ϊ
 * isolation	:����ĸ��뼶��
 * readOnly		:ֻ��
 * rollbackFor	:������Щ�쳣�ع�
 * noRollbackFor:������Щ�쳣���ع�
 */
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void transfer( String out,  String in,  Double money) {
			// ����ʽ�������
				accountDao.outMoney(out, money);
				int i = 1 / 0;
				accountDao.inMoney(in, money);								

	}

}
