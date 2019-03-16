package com.test;

import java.util.Date;
import java.util.List;

import com.dao.DAOFactory;
import com.dao.StudentDao;
import com.entity.Student;

/**
 * 测试类
 * 
 * @author wtt
 */
public class Test {
	static StudentDao dao = DAOFactory.getStudnetDAOInstance();
	//static StudentDaoImpl dao = new StudentDaoImpl();//被dao工厂类代替
	static Student stu = null;

	public static void main(String[] args) {
		// testInsert();
		// testDelete();
		// testUpdate();
		testQuery();
	}

	// 测试增加学生信息
	public static void testInsert() {
		stu = new Student(10, "二狗", "男", 23, "ergou@163.com", new Date());
		dao.insertStudent(stu);
	}

	// 测试通过指定id删除学生信息
	public static void testDelete() {
		stu = new Student();
		dao.deleteStudent(1);
	}

	// 测试通过指定id修改学生信息
	public static void testUpdate() {
		stu = new Student(10, "李四", "男", 26, "lisi@qq.com", new Date());
		dao.updateStudent(stu);
	}

	// 测试通过name查询学生信息(信息在list中)
	public static void testQuery() {
		List<Student> list = dao.query("李四");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
