package com.topup.services.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Web Application configuration
 *
 * @author alexzm1
 */
public class WebApp implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = getApplicationContext();
		setFilters(servletContext);
		setListeners(servletContext, applicationContext);
		setServlet(servletContext, applicationContext);

	}

	/**
	 * Set ServletContext Filters
	 * 
	 * @param servletContext
	 *            An instance of {@link javax.servlet.ServletContext}
	 */
	private void setFilters(ServletContext servletContext) {

		servletContext.addFilter("corsFilter", new CorsFilter())
				.getUrlPatternMappings().add("/TopUp-Services");

	}

	/**
	 * Returns the application context
	 * 
	 * @return an instance of
	 *         {@link org.springframework.context.annotation.AnnotationConfigWebApplicationContext}
	 */
	private AnnotationConfigWebApplicationContext getApplicationContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);

		return context;
	}

	/**
	 * Set ServletContext listeners
	 * 
	 * @param servletContext
	 *            An instance of {@link javax.servlet.ServletContext}
	 */
	private void setListeners(ServletContext servletContext,
			AnnotationConfigWebApplicationContext applicationContext) {

		servletContext.addListener(new RequestContextListener());

		applicationContext.setServletContext(servletContext);
		applicationContext.refresh();

		servletContext
				.addListener(new ContextLoaderListener(applicationContext));

	}

	/**
	 * Set Servlet application
	 * 
	 * @param servletContext
	 *            An implementation instance of
	 *            {@link javax.servlet.ServletContext}
	 * @param applicationContext
	 *            An implementation instance of
	 *            {@link org.springframework.context.ApplicationContext}
	 */
	private void setServlet(ServletContext servletContext,
			ApplicationContext applicationContext) {

		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(MVCConfig.class);
		mvcContext.setParent(applicationContext);
		mvcContext.setServletContext(servletContext);

		ServletRegistration.Dynamic appServlet = servletContext.addServlet(
				"topUpService", new DispatcherServlet(mvcContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/Topup-Services");
	}
}
