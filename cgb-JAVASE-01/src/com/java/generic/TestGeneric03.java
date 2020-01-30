package com.java.generic;
/**
 * 泛型方法:
 * 访问修饰符<泛型>方法名(参数列表){}
 * @author Administrator
 *
 */
class DefaultSqlSession{
	/**
	 * 泛型方法
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
