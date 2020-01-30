package com.java.enums;

enum Sex{
	MALE("��"),FEMALE("Ů");
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
		//���ַ���ת��Ϊö������ʱ,�ַ�����ֵ��Ҫ��ö�����е�ʵ������ͬ(���ִ�Сд)
		Sex sex = Sex.valueOf(sexStr);
//		System.out.println(sex.toString());
		System.out.println(sex.getName());
		m.setSex(sex);
		//��ȡö��������ʵ��
		Sex[] values = Sex.values();
		for(Sex v : values) {
			System.out.println(v.toString());
		}
	}
}
