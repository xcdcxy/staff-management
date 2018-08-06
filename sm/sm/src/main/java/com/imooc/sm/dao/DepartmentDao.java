package com.imooc.sm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.sm.entity.Department;

/*
 * ≤ø√≈Dao
 */
@Repository("departmentDao")
public interface DepartmentDao {
	void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    Department selectById(Integer id);
    List<Department> selectAll();
}
