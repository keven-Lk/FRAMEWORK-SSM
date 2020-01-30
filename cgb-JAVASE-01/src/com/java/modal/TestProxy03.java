package com.java.modal;

import com.java.modal.proxy.DaoProxyFactory;
import com.java.modal.proxy.SearchDao;

public class TestProxy03 {
	public static void main(String[] args) {
		//����һ��������
		DaoProxyFactory factory = new DaoProxyFactory();
		//ͨ������Ϊ�ӿڴ���ʵ�������
		SearchDao dao = factory.newProxy(SearchDao.class);
		System.out.println(dao.getClass().getName());
		dao.search("tmooc");
	}
}
