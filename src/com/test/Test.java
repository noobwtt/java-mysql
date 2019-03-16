package com.test;

import java.util.Date;
import java.util.List;

import com.dao.DAOFactory;
import com.dao.StudentDao;
import com.entity.Student;

/**
 * ������
 * 
 * @author wtt
 */
public class Test {
	static StudentDao dao = DAOFactory.getStudnetDAOInstance();
	//static StudentDaoImpl dao = new StudentDaoImpl();//��dao���������
	static Student stu = null;

	public static void main(String[] args) {
		// testInsert();
		// testDelete();
		// testUpdate();
		testQuery();
	}

	// ��������ѧ����Ϣ
	public static void testInsert() {
		stu = new Student(10, "����", "��", 23, "ergou@163.com", new Date());
		dao.insertStudent(stu);
	}

	// ����ͨ��ָ��idɾ��ѧ����Ϣ
	public static void testDelete() {
		stu = new Student();
		dao.deleteStudent(1);
	}

	// ����ͨ��ָ��id�޸�ѧ����Ϣ
	public static void testUpdate() {
		stu = new Student(10, "����", "��", 26, "lisi@qq.com", new Date());
		dao.updateStudent(stu);
	}

	// ����ͨ��name��ѯѧ����Ϣ(��Ϣ��list��)
	public static void testQuery() {
		List<Student> list = dao.query("����");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
