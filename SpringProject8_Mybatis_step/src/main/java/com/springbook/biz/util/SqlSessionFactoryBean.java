package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;
	
	static {
		try { 
			if (sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				System.out.println("리더 읽어옴");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSessionInstance() {
		System.out.println("세션 객체 생성");
		return sessionFactory.openSession();
	}
}