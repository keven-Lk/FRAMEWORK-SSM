package com.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

public class TestMybatis extends TestBase{
	//重点掌握
	@Test
	public void testSqlSessionFactory() {
		SqlSessionFactory ssf = 
				ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(ssf);
	}
	//了解如何掌握bean对象
	@Test
	public void testSqlSessionFactoryBean() {
		SqlSessionFactoryBean ssf = 
				ctx.getBean("&sqlSessionFactory",SqlSessionFactoryBean.class);
		System.out.println(ssf);
	}
}
