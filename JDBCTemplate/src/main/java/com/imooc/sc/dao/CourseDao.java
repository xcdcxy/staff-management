package com.imooc.sc.dao;

import java.util.List;

import com.imooc.sc.entity.Course;

public interface CourseDao {
	void insert(Course course);
    void update(Course course);
    void delete(int id);
    Course select(int id);
    List<Course> selectAll();
}
