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
		// 完善员工信息
		staff.setPassword("123456");
		staff.setWorkTime(new Date());
		staff.setStatus("正常");
		// 增加员工信息
		staffDao.insert(staff);
	}

	public void remove(Integer id) {
		// 删除员工信息
		staffDao.delete(id);
	}

	public void edit(Staff staff) {
		// 修改员工信息
		staffDao.update(staff);		
	}

	// 根据编号获取员工信息
	public Staff get(Integer id) {
		Staff staff = staffDao.selectById(id);
		return staff;
	}

	/*
	 * 获取所有员工信息
	 */
	public List<Staff> getAll() {
		List<Staff> list = staffDao.selectAll();
		return list;
	}

}
