package com.bookstore.dao;

import com.bookstore.beans.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    // 增
    void saveUser(Connection conn,User user);
    // 查
    User getUser(Connection conn, User user);
    List<User> getAllUser(Connection conn ) ;
    boolean checkUsername(Connection conn,User user);


}
