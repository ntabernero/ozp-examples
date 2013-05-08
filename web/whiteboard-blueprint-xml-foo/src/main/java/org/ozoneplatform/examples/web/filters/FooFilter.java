package org.ozoneplatform.examples.web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class FooFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(FooFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        logger.info("FooFilter:before");

        filterChain.doFilter(servletRequest,servletResponse);

        logger.info("FooFilter:after");

    }

    @Override
    public void destroy() {
    }
}
