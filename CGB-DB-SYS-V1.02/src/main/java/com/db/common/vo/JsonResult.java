package com.db.common.vo;

public class JsonResult {
	/**״̬��:1��ʾok,0��ʾerror*/
	private int state = 1;
	/** * ״̬��Ϣ:״̬���Ӧ�ľ�����Ϣ*/
	private String message = "ok";
	/**��ȷ����(һ�����ڴ洢ҵ�񴦷��ص�����*/
	private Object data;
	
	//���캯��
	public JsonResult() {}
	
	public JsonResult(String message) {
		this.message = message;
	}
	
	public JsonResult(Object data) {
		this.data = data;
	}
	
	public JsonResult(Throwable e) {
		this.state = 0;
		this.message = e.getMessage();
	}
	
	public int getState() {
		return state;
	}
	public void setState(int stat) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
