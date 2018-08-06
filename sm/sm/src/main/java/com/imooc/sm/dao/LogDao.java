package com.imooc.sm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.sm.entity.Log;

/*
 * »’÷æDao
 */
@Repository("logDao")
public interface LogDao {
	 void insert(Log log);
	 List<Log> selectByType(String type);
}
