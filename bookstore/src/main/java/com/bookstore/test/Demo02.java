package com.bookstore.test;

import com.bookstore.beans.User;
import com.bookstore.dao.impl.UserDaoImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig("/hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        UserDaoImpl userDao = new UserDaoImpl();
        List<User> allUser = userDao.getAllUser(connection);
        for ( User u : allUser ) {
            System.out.println(u);
        }


    }

}
