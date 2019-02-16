package com.topup.services.web;

import com.topup.services.web.filter.CORSFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <b>CORSFilterTest</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public class CORSFilterTest {

    private MockFilterChain mockFilterChain;
    private MockHttpServletRequest httpServletRequest;
    private MockHttpServletResponse httpServletResponse;

    @BeforeEach
    public void setup() {
        mockFilterChain = new MockFilterChain();
        httpServletRequest = new MockHttpServletRequest("GET",
                "/api/telephone/1234567890");
        httpServletResponse = new MockHttpServletResponse();
    }

    @Test
    public void testDoFilte() throws IOException, ServletException {
        final CORSFilter corsFilter = new CORSFilter();
        corsFilter.doFilter(httpServletRequest, httpServletResponse,
                mockFilterChain);
        assertEquals("POST, GET, OPTIONS, DELETE",
                httpServletResponse.getHeader("Access-Control-Allow-Methods"));
        assertEquals("*",
                httpServletResponse.getHeader("Access-Control-Allow-Origin"));
        assertEquals("3600",
                httpServletResponse.getHeader("Access-Control-Max-Age"));
        assertEquals("x-requested-with",
                httpServletResponse.getHeader("Access-Control-Allow-Headers"));
    }

}
