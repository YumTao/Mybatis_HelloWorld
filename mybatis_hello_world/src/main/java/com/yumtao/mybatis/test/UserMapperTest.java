package com.yumtao.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yumtao.mybatis.mapper.StudentMapper;
import com.yumtao.mybatis.pojo.Student;

/**
 * mybatis demo
 * @author yumTao
 *
 */
public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 初始化session工厂
	 */
	@Before
	public void getSessionFactory() {
		try {
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();					
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");	// 读取配置文件
			sqlSessionFactory = ssfb.build(inputStream);									// 加载session工厂
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入数据
	 */
	@Test
	public void testAddStudent() {
		SqlSession session = sqlSessionFactory.openSession(false);	// 获取session,关闭自动提交事务
		StudentMapper mapper = session.getMapper(StudentMapper.class);	// 获取mapper
		
		// 初始化student对象
		Student student = new Student();
		student.setName("张三");
		student.setAge(18);
		student.setGender(1);
		
		// 向数据库插入数据
		mapper.addStudent(student);
		System.out.println("插入的数据主键id为: " + student.getId());
		
		// 提交事务
		session.commit();
	}

	/**
	 * 根据主键查询
	 */
	@Test
	public void testQueryStudentById() {
		SqlSession session = sqlSessionFactory.openSession(false);	// 获取session,关闭自动提交事务
		StudentMapper mapper = session.getMapper(StudentMapper.class);	// 获取mapper
		
		// 向数据库插入数据
		Student student = mapper.queryStudentById(1);
		System.out.println("student: " + student);
	}

	/**
	 * 更新student
	 */
	@Test
	public void testUpdateStudentById() {
		SqlSession session = sqlSessionFactory.openSession(false);	// 获取session,关闭自动提交事务
		StudentMapper mapper = session.getMapper(StudentMapper.class);	// 获取mapper
		
		Student student = mapper.queryStudentById(1);	// 查询id为1的student
		// 修改student
		student.setName("肉丝");
		student.setGender(2);
		
		// 更新数据库
		mapper.updateStudentById(student);
		
		// 提交事务
		session.commit();
		System.out.println("student修改后为: " + student);
	}

	/**
	 * 删除student
	 */
	@Test
	public void testDeleteStudentById() {
		SqlSession session = sqlSessionFactory.openSession(false);	// 获取session,关闭自动提交事务
		StudentMapper mapper = session.getMapper(StudentMapper.class);	// 获取mapper
		
		// 删除数据
		mapper.deleteStudentById(1);
		
		// 提交事务
		session.commit();
	}


}
