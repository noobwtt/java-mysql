package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 工具类DBUtil对jdbc进行封装
 * 
 * @author wtt
 *引入的mysql驱动jar包为：mysql-connector-java-8.0.15.jar
 */
public class DBUtil {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/student?serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "root";
	private static Connection conn = null;

	/*
	 * 静态代码块 注册/加载 数据库驱动
	 * 
	 */
	static {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// 对外提供公共类 得到连接和关闭资源
	public static Connection getConnection() {
		return conn;
	}

	public static void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public static void close(Statement stat) throws SQLException {
		if (stat != null) {
			stat.close();
		}
	}

	public static void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}
