package com.db.sys.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
//����Ҫ����spring����
//2.�����л���mybatisAPI�������ݿ�����
public class SysLogDaoImpl {
//
//	//spring�ײ�ͨ��DI����Ϊ���Ը�ֵ
////	@Autowired
//	private SqlSessionFactory sqlSessionFactory;
//	//ͨ��set����Ϊ���Ը�ֵ
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		this.sqlSessionFactory = sqlSessionFactory;
//	}
//	@Override
//	public Map<String, Object> findById(Integer id) {
//		//1.��ȡsqlsession����
//		SqlSession session = sqlSessionFactory.openSession();
//		//2.ִ�в�ѯ����
//		//2.1��ʽ1
////		String statment = "com.db.sys.dao.SysLogDao.findById";
////		Map<String, Object> map = session.selectOne(statment, id);
//		//2.2��ʽ2
//		SysLogDao dao = session.getMapper(SysLogDao.class);
//		Map<String,Object> map = dao.findById(9);
//		//3.�ͷ���Դ
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
