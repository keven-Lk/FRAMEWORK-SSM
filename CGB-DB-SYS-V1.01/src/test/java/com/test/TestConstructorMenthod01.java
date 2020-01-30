package com.test;

class JsonResult{
	private int state = 1;
	private String message;
	private Object data;//不要写其他的
	public JsonResult() {
	}
	
	public JsonResult(String message) throws Exception{
		this.message = message;
	}
	public JsonResult(int state,String message) throws Exception{
		this(message);//this.message = message;
		this.state = state;
	}
	/**
	 * 构造方法
	 * 1)方法名与类名相同
	 * 2)没有返回值类型
	 * 构造方法重载
	 * 参数列表不同的构造方法称之为构造方法重载
	 * @param e
	 */
	public JsonResult(Throwable e) {
		this.state = 0;
		this.message = e.getMessage();
	}
}

public class TestConstructorMenthod01 {

}
