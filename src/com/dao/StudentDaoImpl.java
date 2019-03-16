package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;
import com.util.DBUtil;

/**
 * studentDAO��ʵ���࣬��Բ�ͬ���ݿ����DAO�ӿڶ��巽���ľ���ʵ��
 * 
 * @author wtt
 *
 */
public class StudentDaoImpl implements StudentDao {

	/**
	 * ����ѧ����Ϣ
	 */
	public void insertStudent(Student s) {
		String sql = "insert into stu values(?,?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// �õ����ݿ�����
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			// ��ΪԤ����sql���ò���
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getSex());
			pstmt.setInt(4, s.getAge());
			pstmt.setString(5, s.getEmail());
			pstmt.setDate(6, new Date(s.getDate().getTime()));
			// ������executeִ��sql���
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر���Դ
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ɾ��ѧ����Ϣ��ͨ��id
	 */
	public void deleteStudent(Integer id) {
		String sql = "delete from stu where id = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ����ѧ����Ϣͨ��id
	 */
	public void updateStudent(Student s) {
		String sql = "update stu set name=?,sex=?,age=?,email=?,date=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getSex());
			pstmt.setInt(3, s.getAge());
			pstmt.setString(4, s.getEmail());
			pstmt.setDate(5, new Date(s.getDate().getTime()));
			pstmt.setInt(6, s.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ͨ��������ѯѧ��������Ϣ(��Ϣ������list)
	 */
	public List<Student> query(String name) {
		String sql = "select * from stu where name=?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			// ��ִ��sql��䲢���ؽ����
			rs = pstmt.executeQuery();
			stu = new Student();
			while (rs.next()) {
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setEmail(rs.getString("email"));
				stu.setDate(rs.getDate("date"));
				list.add(stu);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
