/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import util.MySQLConnUtil;
import util.MyUtil;

/**
 *
 * @author thuctap02
 */
@WebFilter(filterName = "servletFilter", urlPatterns = {"/*"})
public class ServletFilter implements Filter {

    public boolean needJDBC(HttpServletRequest request) {
        System.out.println("Servlet Filter");

        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String urlPattern = servletPath;
        if (pathInfo != null) {
            urlPattern += "/*";
        }

        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mapping = sr.getMappings();
            if (mapping.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        Connection conn = null;
        try {
            if (needJDBC((HttpServletRequest) request)) {
                conn = MySQLConnUtil.getMySQLConnection();
                conn.setAutoCommit(false);
                MyUtil.storeConnection(request, conn);
                chain.doFilter(request, response);
                conn.commit();

            } else {
                chain.doFilter(request, response);
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ServletFilter.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletFilter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {

    }

}
