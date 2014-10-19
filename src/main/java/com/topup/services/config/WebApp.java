package com.topup.services.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * <b>WebApp</b>
 *
 * Web Application configuration
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class WebApp implements WebApplicationInitializer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onStartup(final ServletContext servletContext)
			throws ServletException {
		final AnnotationConfigWebApplicationContext applicationContext = getApplicationContext();
		servletContext
				.addListener(new ContextLoaderListener(applicationContext));
		setServlet(servletContext, applicationContext);

	}

	/**
	 * Returns the application context
	 * 
	 * @return an instance of
	 *         {@link org.springframework.context.annotation.AnnotationConfigWebApplicationContext}
	 */
	private AnnotationConfigWebApplicationContext getApplicationContext() {
		final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);

		return context;
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
	private void setServlet(final ServletContext servletContext,
			final ApplicationContext applicationContext) {

		final AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(MVCConfig.class);
		mvcContext.setParent(applicationContext);
		mvcContext.setServletContext(servletContext);

		final ServletRegistration.Dynamic appServlet = servletContext
				.addServlet("topUpService", new DispatcherServlet(mvcContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/*");
	}

}
