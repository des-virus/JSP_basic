/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDAO;
import java.sql.Connection;
import java.sql.SQLException;
import model.UserAccount;
import util.MySQLConnUtil;

/**
 *
 * @author thuctap02
 */
public class TestConn {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnUtil.getMySQLConnection();
        UserDAO userDAO = new UserDAO();
        String username = "minhphong306";
        String password = "123";
        UserAccount user = userDAO.findUser(conn, username);
        if(user == null){
            System.out.println("** Can't find user " + username);
        } else {
            System.out.println("** Find user " + username + " gender : " + user.getGender());
        }
    }
}
