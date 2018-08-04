package com.imooc.sc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.imooc.sc.dao.StudentDao;
import com.imooc.sc.entity.Student;

@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(Student stu) {
		// TODO Auto-generated method stub

	}

	public void update(Student stu) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Student select(int id) {
		String sql = "select * from student where id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new CourseRow() , id);		
		return student;
	}

	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class CourseRow implements RowMapper<Student> {

		public Student mapRow(ResultSet rs, int i) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setSex(rs.getString("sex"));
			student.setBorn(rs.getDate("born"));					
			return student;
		}
		
	}

}


