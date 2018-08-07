package com.imooc.sm.service;

import java.util.List;

import com.imooc.sm.entity.Department;

public interface DepartmentService {
		void add(Department department);
	    void remove(Integer id);
	    void edit(Department department);
	    Department get(Integer id);
	    List<Department> getAll();
}
