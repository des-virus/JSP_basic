/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserAccount;
import util.MySQLConnUtil;

/**
 *
 * @author thuctap02
 */
public class UserDAO {

    public UserAccount findUser(Connection conn, String username, String password) {
        UserAccount user = null;
        String sql = "SELECT u.id, u.username, u.password, u.gender, u.name, u.note "
                + " FROM user_account u "
                + " WHERE u.username = ? and u.password = ?";
        try {
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new UserAccount();
                user.setId(rs.getString("id"));
                user.setUsername(username);
                user.setPassword(password);
                user.setGender(rs.getString("gender"));
                user.setNote(rs.getString("note"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    public UserAccount findUser(Connection conn, String username) {
        UserAccount user = null;
        String sql = "SELECT u.id, u.username, u.password, u.gender, u.name, u.note "
                + " FROM user_account u "
                + " WHERE u.username = ?";
        try {
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                user = new UserAccount();
                user.setId(rs.getString("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setNote(rs.getString("note"));
                user.setGender(rs.getString("gender"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    public boolean insertUser(Connection conn, UserAccount user) {
        boolean result = false;
        String sql = "INSERT INTO `user_account`( `username`, `password`, `gender`, `name`, `note`)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getNote());

            if (pstmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<UserAccount> getAllUsers() throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtil.getMySQLConnection();
        List<UserAccount> users = new ArrayList<>();
        String sql = "SELECT ua.id, ua.username, ua.password, ua.gender, ua.name, ua.note "
                + "FROM `user_account` ua ";
        PreparedStatement pstmt = conn.prepareCall(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            UserAccount user = new UserAccount();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setGender(rs.getString("gender"));
            user.setNote(rs.getString("note"));
            users.add(user);
        }
        return users;
    }
}
