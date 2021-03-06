/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserAccount;
import sun.rmi.server.Dispatcher;
import util.MySQLConnUtil;
import util.MyUtil;

/**
 *
 * @author thuctap02
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
    private UserDAO userDAO;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("haha", "haa value");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userDAO = new UserDAO();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        boolean is_remember = "Y".equals(remember);
        
        System.out.println(username + "-" + password + "-" + remember);
        
        UserAccount user = null;
        boolean has_error = false;
        String error_string = "";
        
        if(username.isEmpty() || password.isEmpty() || username == null || password == null){
            has_error = true;
            error_string = "Vui lòng nhập vào tài khoản và mật khẩu";
        } else{
            Connection conn = MyUtil.getStoredConnection(request);
            user = userDAO.findUser(conn, username, password);
            if(user == null){
                has_error = true;
                error_string = "Tài khoản hoặc mật khẩu không đúng";
            }
        }
        
        if(has_error){
            System.out.println(error_string);
            request.setAttribute("error_string", error_string);
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/pages/login.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/user");
        }
    }

}
