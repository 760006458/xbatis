package com.xforceplus.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xuan
 * @create 2020-01-10 18:00
 **/
public class Executor {

    public <T> T query(String statement, Object parameter) {
        return execute(String.format(statement, parameter));
    }

    public <T> T execute(String sql) {
        Connection conn = null;
        Statement stat = null;
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            conn = DriverManager.getConnection(url, "root", "xuan");
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 释放资源
            try {
                assert stat != null;
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T) user;
    }
}
