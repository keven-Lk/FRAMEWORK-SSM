package com.java.reflect;

/*
 * 通过此对象存储bean.xml文件中bean的定义信息
 */
public class BeanDefinition {
	private String id;
	private String className;
	private boolean lazy = false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public boolean getLazy() {
		return lazy;
	}
	public void setLazy(boolean lazy) {
		this.lazy = lazy;
	}
	
	@Override
	public String toString() {
		return "BeanDefinition [id=" + id + ", className=" + className + ", lazy=" + lazy + "]";
	}
}
