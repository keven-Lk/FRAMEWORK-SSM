package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention 描述注解何时有效
 * @Target 用于描述可以描述那些成员
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//表示只能描述类
@interface Entity{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)//表示只能描述属性
@interface ID{}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@interface RequestMapping{
	//定义注解属性
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
