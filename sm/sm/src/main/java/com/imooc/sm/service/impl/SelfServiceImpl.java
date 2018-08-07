package com.imooc.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.sm.dao.SelfDao;
import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
	
	@Autowired
	private SelfDao selfDao;
	
	@Autowired
	private StaffDao staffDao;
	
	public Staff login(String account, String password) {
		Staff staff = selfDao.selectByAccount(account);
		// δ��ѯ���û�
		if(staff == null) return null;
		// �û�����������ȷ
		if(staff.getPassword().equals(password))
			return staff;
		// �������
		return null;
	}

	public void changePassword(Integer id, String password) {
		Staff staff = new Staff();
		staff.setId(id);
		staff.setPassword(password);
		staffDao.update(staff);
	}

}
