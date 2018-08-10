package com.test.spring.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money - ? where name = ? ";
		jdbcTemplate.update(sql,money,out);
	}

	@Override
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money + ? where name = ? ";
		jdbcTemplate.update(sql, money, in);
	}

}
