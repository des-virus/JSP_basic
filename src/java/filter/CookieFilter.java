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
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.UserAccount;
import util.Constants;

/**
 *
 * @author thuctap02
 */
@WebFilter(filterName = "CookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            
            UserAccount user = (UserAccount) session.getAttribute(Constants.ATT_STORE_USER);
            if(user != null){
                session.setAttribute(Constants.ATT_CHECKED_COOKIE_IN_THIS_SESSION, "CHECKED");
                chain.doFilter(request, response);
                return;
            }
            
            
        
        
            System.out.println("Before Cookie Filter");
            chain.doFilter(request, response);
            System.out.println("After Cookie Filter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
