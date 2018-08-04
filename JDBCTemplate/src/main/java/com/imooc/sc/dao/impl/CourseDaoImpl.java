package com.imooc.sc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.imooc.sc.dao.CourseDao;
import com.imooc.sc.entity.Course;
// ¿ØÖÆ·´×ª
@Repository("courseDao")
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(Course course) {

	}

	public void update(Course course) {		
		String sql = "update course set name=?,score=? where id=?";
		jdbcTemplate.update(sql, course.getName(),course.getScore(),course.getId());
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Course select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Course> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
