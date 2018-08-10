package com.test.spring.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@Override
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money - ? where name = ? ";
		JdbcTemplate.update(sql,money,out);
	}

	@Override
	public void inMoney(String in, Double money) {
		// TODO Auto-generated method stub

	}

}
