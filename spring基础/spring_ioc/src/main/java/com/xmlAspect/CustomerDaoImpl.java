package com.xmlAspect;

public class CustomerDaoImpl implements CustomerDao {

	public void save() {
		System.out.println("����...");
	}

	public String update() {
		System.out.println("�޸�...");
		return "�޸����";
	}

	public void delete() { 
		System.out.println("ɾ��");
	}

}
