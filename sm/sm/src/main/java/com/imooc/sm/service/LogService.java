package com.imooc.sm.service;

import java.util.List;

import com.imooc.sm.entity.Log;

public interface LogService {
	  	void addSystemLog(Log log);
	    void addLoginLog(Log log);
	    void addOperationLog(Log log);

	    List<Log> getSystemLog();
	    List<Log> getLoginLog();
	    List<Log> getOperationLog();
}
