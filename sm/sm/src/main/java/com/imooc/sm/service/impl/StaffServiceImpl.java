package com.imooc.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.StaffService;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	
	public void add(Staff staff) {
		// TODO Auto-generated method stub

	}

	public void remove(Integer id) {
		// ɾ��Ա����Ϣ
		staffDao.delete(id);
	}

	public void edit(Staff staff) {
		// TODO Auto-generated method stub

	}

	// ���ݱ�Ż�ȡԱ����Ϣ
	public Staff get(Integer id) {
		Staff staff = staffDao.selectById(id);
		return staff;
	}

	/*
	 * ��ȡ����Ա����Ϣ
	 */
	public List<Staff> getAll() {
		List<Staff> list = staffDao.selectAll();
		return list;
	}

}
