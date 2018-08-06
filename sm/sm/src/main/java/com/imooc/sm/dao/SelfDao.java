package com.imooc.sm.dao;

import org.springframework.stereotype.Repository;

import com.imooc.sm.entity.Staff;

/*
 * ∆’Õ®Dao
 */
@Repository("selfDao")
public interface SelfDao {
	Staff selectByAccount(String account);
}
