package com.java.TestSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/*
 * ���ڴ˶���洢�û���Ϊ��־
 */
class SysLog implements Serializable{
	private static final long serialVersionUID = 7537105812506022914L;
	/*��־id*/
	//�ؼ���transient��ֹ���л�
	private transient Integer id;
	/*�����û�*/
	private String username;
	//private Date CreatedTime;
	//......
	
	/*�˷������ڵ��ö�������writeObject����ʱִ��*/
	private void writeObject(ObjectOutputStream out) throws Exception {
		System.out.println("wwwwwwwww");
		//1.��ȡһ�����ܶ���(java.util)
		Encoder encoder = Base64.getEncoder();
		//2.�����ݽ��м���
		byte[] array = encoder.encode(username.getBytes());
		//3.�����ܽ�����¸�ֵ��username
		username = new String(array);
		//4.ִ��Ĭ�����л�
		out.defaultWriteObject();//���л�
	}//������������һ�ֹ淶
	
	private void readObject(ObjectInputStream in) throws Exception {
		//1.ִ��Ĭ�Ϸ����л�
		in.defaultReadObject();
		//2.��ȡ���ܶ���
		Decoder decoder = Base64.getDecoder();
		//3.ִ�н��ܲ���
		byte[] array = decoder.decode(username);
		username = new String(array);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "SysLog [id=" + id + ", username=" + username + "]";
	}
}

public class TestSerializable {
	public static void main(String[] args) throws Exception {
		//1.������־����,���洢����
		SysLog log = new SysLog();
		log.setId(1);
		log.setUsername("tmooc");
		//2.�������������,����־����洢���ļ�
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("f1.date"));
		out.writeObject(log);
		System.out.println("���л�ok");
		out.close();
		
		//3.���ļ��е���־���ݶ���
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("f1.date"));
		Object obj = in.readObject();
		in.close();
		System.out.println(obj);
	}
}
