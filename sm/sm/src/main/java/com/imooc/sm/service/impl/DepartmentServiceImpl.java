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
		// ���Ӳ���
		departmentDao.insert(department);
	}

	public void remove(Integer id) {
		// ���ݱ��ɾ������
		departmentDao.delete(id);
	}

	public void edit(Department department) {
		// �޸Ĳ�����Ϣ
		departmentDao.update(department);
	}

	public Department get(Integer id) {
		return  departmentDao.selectById(id);		
	}

	/*
	 * ��ѯ���в�����Ϣ
	 */
	public List<Department> getAll() {
		List<Department> list = departmentDao.selectAll();
		return list;
	}

}
