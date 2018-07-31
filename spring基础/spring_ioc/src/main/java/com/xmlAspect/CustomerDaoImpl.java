package com.xmlAspect;

public class CustomerDaoImpl implements CustomerDao {

	public void save() {
		System.out.println("保存...");
	}

	public String update() {
		System.out.println("修改...");
		return "修改完毕";
	}

	public void delete() { 
		System.out.println("删除");
	}

}
