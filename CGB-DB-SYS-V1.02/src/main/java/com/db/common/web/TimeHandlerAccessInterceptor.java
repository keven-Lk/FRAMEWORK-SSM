package com.db.common.web;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TimeHandlerAccessInterceptor extends HandlerInterceptorAdapter {
	/**���Ʋ��Ŀ�귽��ִ��֮ǰִ��
	 * @return �˷���ֵ��������ǵ������Ƿ�Ҫ�������ִ����ִ��
	 * */
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		System.out.println("preHandle");
		//��ȡ��ǰʱ�����������
		Calendar c = Calendar.getInstance();
		//�޸ĵ�ǰʱ��ʱ����
		c.set(Calendar.HOUR_OF_DAY, 14);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		//��ȡ�޸��Ժ��ʱ����(������Ϊ���ʿ�ʼʱ��)
		long startTime = c.getTimeInMillis();
		//��ȡ�޸��Ժ��ʱ�����ֵ(������Ϊ���ʽ���ʱ��)
		c.set(Calendar.HOUR_OF_DAY, 23);
		long endTime = c.getTimeInMillis();
		long currentTime = System.currentTimeMillis();
		if(currentTime<startTime||currentTime>endTime)
			throw new SerialException("���ڷ���ʱ����");
		return true;//true��ʾ����
	}
	
}
