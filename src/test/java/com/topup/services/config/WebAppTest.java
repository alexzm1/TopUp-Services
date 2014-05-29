package com.topup.services.config;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockServletContext;

@RunWith(MockitoJUnitRunner.class)
public class WebAppTest {

	@Mock
	private MockServletContext servletContext;

	@Mock
	private ServletRegistration.Dynamic servletDynamic;

	@Mock
	private FilterRegistration.Dynamic filterDynamic;

	@Before
	public void before() {
		when(
				servletContext.addServlet(Matchers.anyString(),
						Matchers.any(Servlet.class)))
				.thenReturn(servletDynamic);
		when(
				servletContext.addFilter(Matchers.anyString(),
						Matchers.any(Filter.class))).thenReturn(filterDynamic);
		when(servletContext.getInitParameterNames()).thenReturn(
				mockInitParameterNames());
		when(servletContext.getAttributeNames()).thenReturn(
				mockInitParameterNames());
	}

	@Test
	public void testServlet() throws ServletException {

		new WebApp().onStartup(servletContext);

		verify(servletContext, atLeast(1)).addListener(
				Matchers.any(EventListener.class));

	}

	/**
	 * Returns an implementation instance of Enumeration<String>
	 * 
	 * @return An instance of
	 *         {@link com.topup.services.config.WebAppTest.StringEnumeration}
	 */
	private Enumeration<String> mockInitParameterNames() {
		return new StringEnumeration();
	}

	/**
	 * String Enumeration class used to mock Init Paramenters Names in the
	 * Servlet
	 * 
	 * @author alexzm1
	 *
	 */
	class StringEnumeration implements Enumeration<String> {

		private Iterator<String> enumeration;

		StringEnumeration() {
			List<String> list = new ArrayList<>();
			list.add("Value");
			enumeration = list.listIterator();
		}

		@Override
		public boolean hasMoreElements() {
			return enumeration.hasNext();
		}

		@Override
		public String nextElement() {
			return enumeration.next();
		}

	}

}
