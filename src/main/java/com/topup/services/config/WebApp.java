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
 * Web Application configuration
 *
 * @author alexzm1
 */
public class WebApp implements WebApplicationInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
	 * .ServletContext)
	 */
	@Override
	public void onStartup(final ServletContext servletContext)
			throws ServletException {
		final AnnotationConfigWebApplicationContext applicationContext = getApplicationContext();
		setListeners(servletContext, applicationContext);
		// setFilters(servletContext);
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
	 * Set ServletContext listeners
	 * 
	 * @param servletContext
	 *            An instance of {@link javax.servlet.ServletContext}
	 */
	private void setListeners(final ServletContext servletContext,
			final AnnotationConfigWebApplicationContext applicationContext) {

		/*
		 * servletContext.addListener(new RequestContextListener());
		 * 
		 * applicationContext.setServletContext(servletContext);
		 * applicationContext.refresh();
		 */

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
