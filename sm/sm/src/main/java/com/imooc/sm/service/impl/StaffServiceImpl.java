package com.imooc.sm.service.impl;

import java.awt.image.RescaleOp;
import java.util.Date;
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
		// ����Ա����Ϣ
		staff.setPassword("123456");
		staff.setWorkTime(new Date());
		staff.setStatus("����");
		// ����Ա����Ϣ
		staffDao.insert(staff);
	}

	public void remove(Integer id) {
		// ɾ��Ա����Ϣ
		staffDao.delete(id);
	}

	public void edit(Staff staff) {
		// �޸�Ա����Ϣ
		staffDao.update(staff);		
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
