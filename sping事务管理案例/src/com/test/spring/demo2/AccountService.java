package com.test.spring.demo2;

public interface AccountService {

	/**
	 * @param out	：转出的账号
	 * @param in	：转入的账号
	 * @param money	：转账的金额
	 */
	public void transfer(String out,String in,Double money );
}
