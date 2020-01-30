package com.db.common.web;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TimeHandlerAccessInterceptor extends HandlerInterceptorAdapter {
	/**控制层层目标方法执行之前执行
	 * @return 此方法值会决定我们的请求是否要交给后端执行器执行
	 * */
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		System.out.println("preHandle");
		//获取当前时间的日历对象
		Calendar c = Calendar.getInstance();
		//修改当前时间时分秒
		c.set(Calendar.HOUR_OF_DAY, 14);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		//获取修改以后的时分秒(可以作为访问开始时间)
		long startTime = c.getTimeInMillis();
		//获取修改以后的时间毫秒值(可以作为访问结束时间)
		c.set(Calendar.HOUR_OF_DAY, 23);
		long endTime = c.getTimeInMillis();
		long currentTime = System.currentTimeMillis();
		if(currentTime<startTime||currentTime>endTime)
			throw new SerialException("不在访问时间内");
		return true;//true表示放行
	}
	
}
