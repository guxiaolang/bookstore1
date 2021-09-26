package com.bookstore.test;

import com.bookstore.beans.User;
import com.bookstore.dao.impl.UserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "root");

        /*User lisi = new User("lisi", "123", "123@qq.com");
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.saveUser(connection,lisi);*/

        /*UserDaoImpl userDao = new UserDaoImpl();
        User tempUser = new User();
        tempUser.setId(8);
        User user = userDao.getUser(connection, tempUser);
        System.out.println(user);*/

        /*UserDaoImpl userDao = new UserDaoImpl();
        List<User> allUser = userDao.getAllUser(connection);
        for (User u : allUser ) {
            System.out.println(u);
        }*/


        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("wangwu");
        boolean flag = userDao.checkUsername(connection, user);
        System.out.println(flag);



    }

}
