package com.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.blog.pojo.Author;

public class TestAuthor01 extends TestBase{
	@Test
	public void testFindAuthor() {
		//1.获取sqlsession对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.执行SQL查询
		String statement = "com.blog.dao.AuthorDao.findAuthor";
		Map<String,Object> map = session.selectOne(statement,1);
		System.out.println(map);
		System.out.println(map.getClass().getName());
		//3.释放资源
		session.close();
	}
	
	@Test
	public void testSelectAuthor() {
		//1.获取sqlsession对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.执行SQL查询
		String namespace = "com.blog.dao.AuthorDao";
		String elementId = "selectAuthor";
		String statement = namespace + "." + elementId;
		Author author = session.selectOne(statement,1);
		System.out.println(author);
		System.out.println(author.getClass().getName());
		//3.释放资源
		session.close();
	}
}