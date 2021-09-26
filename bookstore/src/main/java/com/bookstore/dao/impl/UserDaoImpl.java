package com.bookstore.dao.impl;

import com.bookstore.beans.User;
import com.bookstore.dao.BaseDao;
import com.bookstore.dao.UserDao;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {


    @Override
    public void saveUser(Connection conn, User user) {
        String sql = "insert into users(username,password,email) values(?,?,?)";
        update(conn, sql , user.getUsername() , user.getPassword() , user.getEmail());
    }

    @Override
    public User getUser(Connection conn, User user) {
        String sql = "select * from users where id = ? ";
        User resUser = getBean(conn, sql, user.getId() );
        return resUser;
    }

    @Override
    public List<User> getAllUser(Connection conn) {
        String sql = "select * from users " ;
        List<User> usersList = getBeanList(conn, sql);
        return usersList;
    }

    @Override
    public boolean checkUsername(Connection conn, User user) {
        String sql = "select * from users where username = ? ";
        User bean = getBean(conn, sql, user.getUsername());
        return bean != null ;
    }
}
