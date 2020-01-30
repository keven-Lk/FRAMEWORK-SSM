package com.java.reflect;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//模拟spring工厂的一种实现
public class ClassPathXmlApplicationContext {
	//存储bean的配置信息
	private Map<String,BeanDefinition> beanMap = new HashMap<>(); 
	//基于此map存储Bean对象
	private Map<String,Object> instanceMap = new HashMap<>();
	public ClassPathXmlApplicationContext(String file) throws Exception{
		//1.读取文件(IO)
		InputStream in =
				this.getClass().getClassLoader().getResourceAsStream(file);
		//2.解析文件(Xml解析对象)
		parse(in);
		//3.基于文件内容构建对象
	}
	//解析xml,借助Java中自带的API进行解析
	private void parse(InputStream in) throws Exception {
		//1.创建DocumentBuilderFactory对象
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		//2.创建DocumentBuilder对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.创建Document对象(此对象对应是xml文件)
		Document doc = builder.parse(in);
		//4.读取docuoment文件的内容,...
		processDocument(doc);
		//document可以理解为xml文件在内容中的映射
	}
	
	//解析Document节点对象
	private void processDocument(Document doc) throws Exception {
		//4.1获取文档的根元素(一个xml只能有一个根)
		Element root = doc.getDocumentElement();
		//System.out.println(root.getNodeName());
		//4.2获取所有的bean元素
		NodeList list = doc.getElementsByTagName("bean");
		//System.out.println(list.getLength());
		//4.2.1迭代所有的bean元素
		for (int i = 0; i < list.getLength(); i++) {
			//4.2.2获取某个bean元素
			Node node = list.item(i);
			//4.2.3获取bean元素所有属性
			NamedNodeMap nMap = node.getAttributes();
			//4.2.4迭代所有属性,将属性信息封装到BeanDefinition对象
			BeanDefinition bd = parseBeanAttrs(nMap);
			//存储bean配置信息
			beanMap.put(bd.getId(),bd);
			if(!bd.getLazy()) {//假设对象lazy=false,则创建对象实例
				Object obj = newInstance(bd.getClassName());
				//存储bean的实例
				instanceMap.put(bd.getId(),obj);
			}
		}
	}
	
	//读取bean元素中的属性,并将其封装到BeanDefinition对象
	private BeanDefinition parseBeanAttrs(NamedNodeMap nMap) {
		BeanDefinition bd = new BeanDefinition();
		//			System.out.println(node.getNodeName());
		for(int j = 0;j<nMap.getLength();j++) {
			Node attrNode = nMap.item(j);//获取一个属性
			//System.out.println(attrNode);
			String nodeName = attrNode.getNodeName();//获取属性
			if(nodeName.equalsIgnoreCase("id")) {
				bd.setId(attrNode.getNodeValue());
			} else if(nodeName.equalsIgnoreCase("class")) {
				bd.setClassName(attrNode.getNodeValue());
			} else if(nodeName.equalsIgnoreCase("lazy")) {
				bd.setLazy(Boolean.valueOf(attrNode.getNodeValue()));
			}
		}
		return bd;
	}
	//基于反射技术构建类的实例对象
	private Object newInstance(String className) throws Exception {
		Class<?> cls = Class.forName(className);
		Constructor<?> con = cls.getDeclaredConstructor();
		con.setAccessible(true);
		Object obj = con.newInstance();
		return obj;
	}
	//从容器获取对象实例
	public <T>T getBean(String id,Class<T> cls){
		//1.从Bean的实例map中获取对象,有则直接返回
		Object obj = instanceMap.get(id);
		if(obj != null) return (T)obj;
		//2.实例map容器中没有对象,则基于配置信息创建对象
		BeanDefinition bd = beanMap.get(id);
		try {
			obj = newInstance(bd.getClassName());
			//3.将新创建的实例对象存储到实例map容器
			instanceMap.put(bd.getId(),obj);
		} catch (Exception e) {
			e.getMessage();
		}
		return (T)obj;
	}

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("beans.xml");
		Date date = ctx.getBean("date", Date.class);
		System.out.println(date);
	}
}
