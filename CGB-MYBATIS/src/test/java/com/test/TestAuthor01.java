package com.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.blog.pojo.Author;

public class TestAuthor01 extends TestBase{
	@Test
	public void testFindAuthor() {
		//1.��ȡsqlsession����
		SqlSession session = sqlSessionFactory.openSession();
		//2.ִ��SQL��ѯ
		String statement = "com.blog.dao.AuthorDao.findAuthor";
		Map<String,Object> map = session.selectOne(statement,1);
		System.out.println(map);
		System.out.println(map.getClass().getName());
		//3.�ͷ���Դ
		session.close();
	}
	
	@Test
	public void testSelectAuthor() {
		//1.��ȡsqlsession����
		SqlSession session = sqlSessionFactory.openSession();
		//2.ִ��SQL��ѯ
		String namespace = "com.blog.dao.AuthorDao";
		String elementId = "selectAuthor";
		String statement = namespace + "." + elementId;
		Author author = session.selectOne(statement,1);
		System.out.println(author);
		System.out.println(author.getClass().getName());
		//3.�ͷ���Դ
		session.close();
	}
}