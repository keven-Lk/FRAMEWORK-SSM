package com.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

public class TestMybatis extends TestBase{
	//�ص�����
	@Test
	public void testSqlSessionFactory() {
		SqlSessionFactory ssf = 
				ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(ssf);
	}
	//�˽��������bean����
	@Test
	public void testSqlSessionFactoryBean() {
		SqlSessionFactoryBean ssf = 
				ctx.getBean("&sqlSessionFactory",SqlSessionFactoryBean.class);
		System.out.println(ssf);
	}
}
