package com.java.generic;
/**
 * ���ͷ���:
 * �������η�<����>������(�����б�){}
 * @author Administrator
 *
 */
class DefaultSqlSession{
	/**
	 * ���ͷ���
	 * @param cls
	 * @return
	 */
	public <T>T getMapper(Class<T> cls){
		return null;
	}
}
interface SearchDao{}
public class TestGeneric03 {
	public static void main(String[] args) {
		DefaultSqlSession s = new DefaultSqlSession();
		SearchDao obj = s.getMapper(SearchDao.class);
	}
}

class ClassPathXml {
	public <T>T getBean(Class<T> cls){
		T t = null;
		return t;
	}
	
}
