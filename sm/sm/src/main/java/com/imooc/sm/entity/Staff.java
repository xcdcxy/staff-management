package com.imooc.sm.entity;

import java.util.Date;

/*
 * 员工类
 */
public class Staff {

	private Integer id; // 编号
	private String account; // 账号
	private String password; // 密码
	private String status;//状态
	private Integer did; // 部门编号
	private String name; // 姓名
	private String sex; // 性别
	private Integer idNumber;// 员工编号
	private Date workTime;// 入职时间
	private Date leaveTime;// 离职时间
	private Date bornDate;// 出生日期
	private String info;
	private Department department;// 所属部门	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	
}
