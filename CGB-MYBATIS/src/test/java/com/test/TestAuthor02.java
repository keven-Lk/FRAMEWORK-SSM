package com.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.blog.dao.AuthorDao;
/*
 * ���ڽӿڷ�ʽ����
 * 1)����
 * 2)�����Լ��ֶ���дstatement(namespace+elementId)
 * 
 * ����������:
 * 1)�ӿ���ȫ����Ҫ��ӳ���ļ������ռ�(namespace)��ͬ
 * 2)�ӿڷ�������ӳ���ļ�Ԫ��id��ͬ
 * ���粻�������������������ܻ����BindingException
 */
public class TestAuthor02 extends TestBase{
	@Test
	public void testFindAuthor() {
		//1.�����Ự����
		SqlSession session = //DefaultSqlSession
				sqlSessionFactory.openSession();
		//2.���ڻỰ�����ȡĳ��dao�ӿڵ�ʵ�������
		AuthorDao dao = session.getMapper(AuthorDao.class);
		//3.����ʵ�������,����Ŀ�귽��
		Map<String, Object> map1 = dao.findAuthor(1);
		//ͬһ��session�����ͬ���Ĳ�ѯ�����ȴӻ�����ȡ
		session.close();//һ������ʧЧ
		session = sqlSessionFactory.openSession();
		dao = session.getMapper(AuthorDao.class);
		Map<String, Object> map2 = dao.findAuthor(1);
		//˵��:�������ִ��ʱ,ϵͳ�ײ㱾���ϻ������
		//selectiong.selectList(statment,args)
		System.out.println(map1);
		System.out.println(map2);
		//4.�ͷ���Դ
		session.close();
	}

}
