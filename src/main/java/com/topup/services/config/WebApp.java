/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.topup.services.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Samuel Alejandro
 */
public class WebApp implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		setWebApplicationContext(servletContext);
		setFilters(servletContext);
		setListeners(servletContext);

	}

	/**
	 * Return the WebApplicationContext
	 * 
	 * @param servletContext
	 *            An instance of {@link javax.servlet.ServletContext}
	 */
	private void setWebApplicationContext(ServletContext servletContext) {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("com.topup.services");

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"dispatcher", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/TopUp-Services");

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
		servletContext
				.addFilter("springSecurityFilterChain",
						new DelegatingFilterProxy("springSecurityFilterChain"))
				.getUrlPatternMappings().add("/TopUp-Services");

	}

	/**
	 * Set ServletContext listeners
	 * 
	 * @param servletContext
	 *            An instance of {@link javax.servlet.ServletContext}
	 */
	private void setListeners(ServletContext servletContext) {

		servletContext.addListener(new RequestContextListener());
	}
}
