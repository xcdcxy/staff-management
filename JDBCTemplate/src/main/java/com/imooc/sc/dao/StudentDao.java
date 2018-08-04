package com.imooc.sc.dao;

import java.util.List;

import com.imooc.sc.entity.Student;

public interface StudentDao {
	void insert(Student stu);
    void update(Student stu);
    void delete(int id);
    Student select(int id);
    List<Student> selectAll();
}
