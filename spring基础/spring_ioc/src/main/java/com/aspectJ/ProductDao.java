package com.aspectJ;

/*
 * ��������
 */
public class ProductDao {
	public void save(){
        System.out.println("������Ʒ...");
    }
    public String update(){
        System.out.println("�޸���Ʒ...");        
        return "hello";
    }
    public void delete(){
        System.out.println("ɾ����Ʒ...");
    }
    public void findOne(){
        System.out.println("��ѯһ����Ʒ...");        
    }

    public void findAll(){
        System.out.println("��ѯ������Ʒ...");       
    }
}
