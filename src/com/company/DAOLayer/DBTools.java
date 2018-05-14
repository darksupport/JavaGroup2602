package com.company.DAOLayer;

import java.sql.*;

/**
 * Created by Brainacad4 on 14.05.2018.
 */
public class DBTools {

    private static String url = "jdbc:mysql://{serverAddr}:{portAddr}/sockdb";

    public static void CloseStatment(PreparedStatement ps)
    {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void CloseResult(ResultSet rs)
    {
        if (rs != null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection(String serverAddres, int port, String user,String password) throws SQLException {
        url = url.replace("{serverAddr}",serverAddres);
        url = url.replace("{portAddr}",((Integer)port).toString());
        return DriverManager.getConnection(url, user, password);
    }
}
