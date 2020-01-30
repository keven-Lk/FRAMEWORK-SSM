package com.java.enums;

enum Sex{
	MALE("男"),FEMALE("女");
	private String name;
	private Sex(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

class Member{
	private Sex sex = Sex.MALE;
	public void setSex(Sex sex) {
		this.sex = sex;
	}
}

public class TestEnum02 {
	public static void main(String[] args) {
		Member m = new Member();
		String sexStr = "MALE";
		//将字符串转换为枚举类型时,字符串的值需要与枚举类中的实例名相同(区分大小写)
		Sex sex = Sex.valueOf(sexStr);
//		System.out.println(sex.toString());
		System.out.println(sex.getName());
		m.setSex(sex);
		//获取枚举中所有实例
		Sex[] values = Sex.values();
		for(Sex v : values) {
			System.out.println(v.toString());
		}
	}
}
