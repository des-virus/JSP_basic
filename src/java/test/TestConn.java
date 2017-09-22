/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import util.MySQLConnUtil;

/**
 *
 * @author thuctap02
 */
public class TestConn {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(MySQLConnUtil.getMySQLConnection());
    }
}
