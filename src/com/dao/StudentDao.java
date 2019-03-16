package com.dao;

import java.util.List;

import com.entity.Student;

/*DAO类都是进行数据操作的类，
DAO层一般有接口和该接口的实现类，
接口用于规范实现类
实现类一般用于操作数据库！

DAO (DataAccessobjects 数据存取对象)
是指位于业务逻辑和持久化数据之间实现对持久化数据的访问。
通俗来讲，DAO模式就是将数据库操作都封装起来。

DAO 模式的优势就在于它实现了两次隔离。
1、隔离了数据访问代码和业务逻辑代码。
业务逻辑代码直接调用DAO方法即可，完全感觉不到数据库表的存在。
分工明确，数据访问层代码变化不影响业务逻辑代码,这符合单一职能原则，
降低了藕合性，提高了可复用性。
2、隔离了不同数据库实现。
采用面向接口编程，如果底层数据库变化，
如由 MySQL 变成 Oracle 只要增加 DAO 接口的新实现类即可
，原有 MySQ 实现不用修改。
这符合 "开-闭" 原则。该原则降低了代码的藕合性，
提高了代码扩展性和系统的可移植性。

一个典型的DAO 模式主要由以下几部分组成:
DAO接口:接口用于规范实现类
DAO 实现类： 针对不同数据库给出DAO接口定义方法的具体实现。
实体类：用于存放与传输对象数据。
数据库连接和关闭工具类： 避免了数据库连接和关闭代码的重复使用，方便修改。
*/
/**
 * studentDao接口
 * 
 * @author wtt
 *
 */
public interface StudentDao {
	public void insertStudent(Student s);

	public void deleteStudent(Integer id);

	public void updateStudent(Student s);

	public List<Student> query(String name);
}
