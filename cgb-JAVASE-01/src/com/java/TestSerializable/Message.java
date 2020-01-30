package com.java.TestSerializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
/*
 * 通过让类实现Externalizable来指定需要序列化和反序列化的属性
 */
public class Message implements Externalizable{
	private Integer id;
	private String title;
	private String content;
	private String CreatrfTime;
	
	//序列化时调用
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(title);
	}
	//反序列化时调用
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		title = in.readUTF();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatrfTime() {
		return CreatrfTime;
	}
	public void setCreatrfTime(String creatrfTime) {
		CreatrfTime = creatrfTime;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", CreatrfTime=" + CreatrfTime + "]";
	}
	
	//......
	
}
