package com.test;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.blog.dao.AuthorDao;
/*
 * 基于接口方式访问
 * 1)解耦
 * 2)无需自己手动编写statement(namespace+elementId)
 * 
 * 但是有条件:
 * 1)接口类全名需要与映射文件命名空间(namespace)相同
 * 2)接口方法名与映射文件元素id相同
 * 假如不满足如上两个条件可能会出现BindingException
 */
public class TestAuthor02 extends TestBase{
	@Test
	public void testFindAuthor() {
		//1.创建会话对象
		SqlSession session = //DefaultSqlSession
				sqlSessionFactory.openSession();
		//2.基于会话对象获取某个dao接口的实现类对象
		AuthorDao dao = session.getMapper(AuthorDao.class);
		//3.基于实现类对象,调用目标方法
		Map<String, Object> map1 = dao.findAuthor(1);
		//同一个session发起的同样的查询会首先从缓存中取
		session.close();//一级缓存失效
		session = sqlSessionFactory.openSession();
		dao = session.getMapper(AuthorDao.class);
		Map<String, Object> map2 = dao.findAuthor(1);
		//说明:如上语句执行时,系统底层本质上还会调用
		//selectiong.selectList(statment,args)
		System.out.println(map1);
		System.out.println(map2);
		//4.释放资源
		session.close();
	}

}
