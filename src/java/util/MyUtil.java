/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserAccount;



/**
 *
 * @author thuctap02
 */
public class MyUtil {
    public static void storeConnection(ServletRequest request, Connection conn){
        request.setAttribute(Constants.ATT_STORE_CONN, conn);
    }
    
    public static Connection getStoredConnection(ServletRequest request){
        return (Connection) request.getAttribute(Constants.ATT_STORE_CONN);
    }
    
    public void storeLoginedUser(HttpSession session, UserAccount user){
        session.setAttribute(Constants.ATT_STORE_USER, user);
    }
    
    public UserAccount getLoginedUser(HttpSession session){
        return (UserAccount) session.getAttribute(Constants.ATT_STORE_USER);
    }
    
    public void storeUsername(HttpServletResponse response, UserAccount user){
        Cookie usernameCookie = new Cookie(Constants.ATT_STORE_USERNAME, user.getUsername());
        usernameCookie.setMaxAge(Constants.MAX_COOKIE_AGE);
        response.addCookie(usernameCookie);
    }
    
    public static String getStoredUsername(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(Constants.ATT_STORE_USERNAME.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
    public static void deletedUsernameCookie(HttpServletResponse response){
        Cookie cookieUsername = new Cookie(Constants.ATT_STORE_USERNAME, null);
        cookieUsername.setMaxAge(0);
        response.addCookie(cookieUsername);
    }
}
