package com.imooc.sm.entity;

import java.util.Date;

/*
 * 日志类
 */
public class Log {
	private Date oprTime;// 操作时间
	private String 	type;// 操作类型
	private String 	operator;// 操作人
	private String 	moudle;// 操作模块
	private String 	operation;// 具体操作
	private String 	result;// 操作结果
	public Date getOprTime() {
		return oprTime;
	}
	public void setOprTime(Date oprTime) {
		this.oprTime = oprTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getMoudle() {
		return moudle;
	}
	public void setMoudle(String moudle) {
		this.moudle = moudle;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
