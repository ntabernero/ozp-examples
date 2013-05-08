package org.ozoneplatform.examples.web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(TestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        logger.info("TestFilter:before");

        filterChain.doFilter(servletRequest,servletResponse);

        logger.info("TestFilter:after");

    }

    @Override
    public void destroy() {
    }
}
