package com.test;

class JsonResult{
	private int state = 1;
	private String message;
	private Object data;//��Ҫд������
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
	 * ���췽��
	 * 1)��������������ͬ
	 * 2)û�з���ֵ����
	 * ���췽������
	 * �����б�ͬ�Ĺ��췽����֮Ϊ���췽������
	 * @param e
	 */
	public JsonResult(Throwable e) {
		this.state = 0;
		this.message = e.getMessage();
	}
}

public class TestConstructorMenthod01 {

}
