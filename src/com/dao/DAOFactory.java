package com.dao;

/**
 * DAO�����ࣺ��û��DAO�����������£� 
 * ����ͨ������DAOʵ�����ʵ������������ݿ�Ĳ����� 
 * ��ʱҪ�����֪�������ʵ�����࣬���ں��ڵ��޸�ʮ�ֲ��㡣
 * �������Ҫ����һ����DAO�ӿڵ�oracleʵ���ࡣ
 *  ��ʱ�ͱ����޸�����ʹ��DAOʵ����Ĵ��롣
 * ���ʹ��DAO�������һ����̬����(����Ҫ�������󼴿ɵ���)����ȡDAOʵ����ʵ��
 * �� ��ʱ�滻DAOʵ���ֻ࣬���޸�DAO�������еķ������룬
 * ������Ҫ�޸����еĵ���DAOʵ�ֵĴ��롣
 * 
 * 
 * DAO��������һ������ģʽ��������������ݿ�Ĳ�һ�¡�
 * 
 * @author wtt
 *
 */
public class DAOFactory {
	public static StudentDao getStudnetDAOInstance() {
		return new StudentDaoImpl();
	}
}
