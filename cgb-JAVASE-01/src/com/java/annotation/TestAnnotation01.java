package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention ����ע���ʱ��Ч
 * @Target ������������������Щ��Ա
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//��ʾֻ��������
@interface Entity{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)//��ʾֻ����������
@interface ID{}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@interface RequestMapping{
	//����ע������
	String value() default"";
}

@Entity
class SysLog{
	@ID
	private Integer id;
}

@RequestMapping("/")
public class TestAnnotation01 {
	@RequestMapping(value = "doIndexUI")
	public void doIndexUi() {}
}
