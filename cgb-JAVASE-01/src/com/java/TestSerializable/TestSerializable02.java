package com.java.TestSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializable02 {
	public static void main(String[] args) throws Exception {
		Message msg = new Message();
		msg.setId(100);
		msg.setTitle("title-aaa");
		msg.setContent("content--aaa");
		msg.setCreatrfTime("2019-02-28 16:12:12");
		
		//2.构建对象输出流,将日志对象存储到文件
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("f1.date"));
		out.writeObject(msg);
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
