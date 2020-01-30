package com.db.common.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//tomcat启动时会读取此类,并执行此类中的onStart方法
public class AppWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}*/
	/**
	 * 此方法官方建议加载service,respository
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses");
		return new Class[] {SpringRespository.class,SpringService.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}
}