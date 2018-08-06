package com.imooc.sm.service;

import java.util.List;

import com.imooc.sm.entity.Staff;

public interface StaffService {
		void add(Staff staff);
	    void remove(Integer id);
	    void edit(Staff staff);
	    Staff get(Integer id);
	    List<Staff> getAll();
}
