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

//ģ��spring������һ��ʵ��
public class ClassPathXmlApplicationContext {
	//�洢bean��������Ϣ
	private Map<String,BeanDefinition> beanMap = new HashMap<>(); 
	//���ڴ�map�洢Bean����
	private Map<String,Object> instanceMap = new HashMap<>();
	public ClassPathXmlApplicationContext(String file) throws Exception{
		//1.��ȡ�ļ�(IO)
		InputStream in =
				this.getClass().getClassLoader().getResourceAsStream(file);
		//2.�����ļ�(Xml��������)
		parse(in);
		//3.�����ļ����ݹ�������
	}
	//����xml,����Java���Դ���API���н���
	private void parse(InputStream in) throws Exception {
		//1.����DocumentBuilderFactory����
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		//2.����DocumentBuilder����
		DocumentBuilder builder = factory.newDocumentBuilder();
		//3.����Document����(�˶����Ӧ��xml�ļ�)
		Document doc = builder.parse(in);
		//4.��ȡdocuoment�ļ�������,...
		processDocument(doc);
		//document�������Ϊxml�ļ��������е�ӳ��
	}
	
	//����Document�ڵ����
	private void processDocument(Document doc) throws Exception {
		//4.1��ȡ�ĵ��ĸ�Ԫ��(һ��xmlֻ����һ����)
		Element root = doc.getDocumentElement();
		//System.out.println(root.getNodeName());
		//4.2��ȡ���е�beanԪ��
		NodeList list = doc.getElementsByTagName("bean");
		//System.out.println(list.getLength());
		//4.2.1�������е�beanԪ��
		for (int i = 0; i < list.getLength(); i++) {
			//4.2.2��ȡĳ��beanԪ��
			Node node = list.item(i);
			//4.2.3��ȡbeanԪ����������
			NamedNodeMap nMap = node.getAttributes();
			//4.2.4������������,��������Ϣ��װ��BeanDefinition����
			BeanDefinition bd = parseBeanAttrs(nMap);
			//�洢bean������Ϣ
			beanMap.put(bd.getId(),bd);
			if(!bd.getLazy()) {//�������lazy=false,�򴴽�����ʵ��
				Object obj = newInstance(bd.getClassName());
				//�洢bean��ʵ��
				instanceMap.put(bd.getId(),obj);
			}
		}
	}
	
	//��ȡbeanԪ���е�����,�������װ��BeanDefinition����
	private BeanDefinition parseBeanAttrs(NamedNodeMap nMap) {
		BeanDefinition bd = new BeanDefinition();
		//			System.out.println(node.getNodeName());
		for(int j = 0;j<nMap.getLength();j++) {
			Node attrNode = nMap.item(j);//��ȡһ������
			//System.out.println(attrNode);
			String nodeName = attrNode.getNodeName();//��ȡ����
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
	//���ڷ��似���������ʵ������
	private Object newInstance(String className) throws Exception {
		Class<?> cls = Class.forName(className);
		Constructor<?> con = cls.getDeclaredConstructor();
		con.setAccessible(true);
		Object obj = con.newInstance();
		return obj;
	}
	//��������ȡ����ʵ��
	public <T>T getBean(String id,Class<T> cls){
		//1.��Bean��ʵ��map�л�ȡ����,����ֱ�ӷ���
		Object obj = instanceMap.get(id);
		if(obj != null) return (T)obj;
		//2.ʵ��map������û�ж���,�����������Ϣ��������
		BeanDefinition bd = beanMap.get(id);
		try {
			obj = newInstance(bd.getClassName());
			//3.���´�����ʵ������洢��ʵ��map����
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
