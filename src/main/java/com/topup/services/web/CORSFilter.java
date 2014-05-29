/**
 * 
 */
package com.topup.services.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * @author alexzm1
 *
 */
@WebFilter("/*")
public class CORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) sr1;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		fc.doFilter(sr, sr1);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
