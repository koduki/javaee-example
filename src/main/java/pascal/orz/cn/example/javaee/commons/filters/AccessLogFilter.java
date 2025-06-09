/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.commons.filters;

import pascal.orz.cn.example.javaee.commons.utils.ApplicationLogger;
import java.io.IOException;
import jakarta.inject.Inject;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author koduki
 */
public class AccessLogFilter implements Filter {

    @Inject
    ApplicationLogger logger;

    public AccessLogFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        long start = System.currentTimeMillis();

        try {
            chain.doFilter(request, response);
        } finally {
            HttpServletRequest req = (HttpServletRequest) request;

            logger.access(req.getRequestURI(),
                    req.getRemoteAddr(),
                    req.getHeader("User-Agent"),
                    (System.currentTimeMillis() - start));
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
