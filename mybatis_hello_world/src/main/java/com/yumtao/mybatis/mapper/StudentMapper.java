package com.yumtao.mybatis.mapper;

import com.yumtao.mybatis.pojo.Student;

public interface StudentMapper {
	
	/**
	 * 添加student
	 * @param student
	 * @return
	 */
	public Integer addStudent(Student student);
	
	/**
	 * 根据id查询student
	 * @param id
	 * @return
	 */
	public Student queryStudentById(Integer id);
	
	/**
	 * 更新student
	 * @param student
	 */
	public void updateStudentById(Student student);
	
	/**
	 * 根据id删除student
	 * @param id
	 */
	void deleteStudentById(Integer id);
}
