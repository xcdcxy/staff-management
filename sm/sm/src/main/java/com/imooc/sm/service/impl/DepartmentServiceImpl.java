package com.imooc.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.sm.dao.DepartmentDao;
import com.imooc.sm.entity.Department;
import com.imooc.sm.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	public void add(Department department) {
		// TODO Auto-generated method stub

	}

	public void remove(Integer id) {
		// ���ݱ��ɾ������
		departmentDao.delete(id);
	}

	public void edit(Department department) {
		

	}

	public Department get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * ��ѯ���в�����Ϣ
	 */
	public List<Department> getAll() {
		List<Department> list = departmentDao.selectAll();
		return list;
	}

}
