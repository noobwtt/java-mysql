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
 * studentDAO的实现类，针对不同数据库给出DAO接口定义方法的具体实现
 * 
 * @author wtt
 *
 */
public class StudentDaoImpl implements StudentDao {

	/**
	 * 增加学生信息
	 */
	public void insertStudent(Student s) {
		String sql = "insert into stu values(?,?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 得到数据库连接
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			// ↓为预编译sql设置参数
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getSex());
			pstmt.setInt(4, s.getAge());
			pstmt.setString(5, s.getEmail());
			pstmt.setDate(6, new Date(s.getDate().getTime()));
			// ↓调用execute执行sql语句
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭资源
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除学生信息，通过id
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
	 * 更新学生信息通过id
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
	 * 通过姓名查询学生所有信息(信息保存在list)
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
			// ↓执行sql语句并返回结果集
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
