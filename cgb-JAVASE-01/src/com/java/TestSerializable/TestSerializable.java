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
 * 基于此对象存储用户行为日志
 */
class SysLog implements Serializable{
	private static final long serialVersionUID = 7537105812506022914L;
	/*日志id*/
	//关键字transient禁止序列化
	private transient Integer id;
	/*操作用户*/
	private String username;
	//private Date CreatedTime;
	//......
	
	/*此方法会在调用对象流的writeObject方法时执行*/
	private void writeObject(ObjectOutputStream out) throws Exception {
		System.out.println("wwwwwwwww");
		//1.获取一个加密对象(java.util)
		Encoder encoder = Base64.getEncoder();
		//2.对内容进行加密
		byte[] array = encoder.encode(username.getBytes());
		//3.将加密结果重新赋值给username
		username = new String(array);
		//4.执行默认序列化
		out.defaultWriteObject();//序列化
	}//方法的声明是一种规范
	
	private void readObject(ObjectInputStream in) throws Exception {
		//1.执行默认反序列化
		in.defaultReadObject();
		//2.获取解密对象
		Decoder decoder = Base64.getDecoder();
		//3.执行解密操作
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
		//1.构建日志对象,并存储数据
		SysLog log = new SysLog();
		log.setId(1);
		log.setUsername("tmooc");
		//2.构建对象输出流,将日志对象存储到文件
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("f1.date"));
		out.writeObject(log);
		System.out.println("序列化ok");
		out.close();
		
		//3.将文件中的日志数据读出
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("f1.date"));
		Object obj = in.readObject();
		in.close();
		System.out.println(obj);
	}
}
