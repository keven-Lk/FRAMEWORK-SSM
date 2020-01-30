package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestBase {
	protected SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException {
		String resource = "mybatis-configs.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testSqlSession() {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(session);
	}
}
