package com.db.sys.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
//此类要交给spring管理
//2.此类中基于mybatisAPI操作数据库数据
public class SysLogDaoImpl {
//
//	//spring底层通过DI机制为属性赋值
////	@Autowired
//	private SqlSessionFactory sqlSessionFactory;
//	//通过set方法为属性赋值
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		this.sqlSessionFactory = sqlSessionFactory;
//	}
//	@Override
//	public Map<String, Object> findById(Integer id) {
//		//1.获取sqlsession对象
//		SqlSession session = sqlSessionFactory.openSession();
//		//2.执行查询操作
//		//2.1方式1
////		String statment = "com.db.sys.dao.SysLogDao.findById";
////		Map<String, Object> map = session.selectOne(statment, id);
//		//2.2方式2
//		SysLogDao dao = session.getMapper(SysLogDao.class);
//		Map<String,Object> map = dao.findById(9);
//		//3.释放资源
//		session.close();
//		return map;
//	}
//
//	@Override
//	public int getRowCount(String username) {
//		// TODO Auto-generated method stub
//		return 0;
//	}


	
}
