package com.bookstore.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
    提供书和用户共有的操作
 */
public abstract class BaseDao<T> {
    // 用来判断子类是哪一个 BookDao UserDao
    private Class<T> type;
    public BaseDao() {
        // 获取⼦类的类型
        Class clazz = this.getClass();
        // 获取⽗类的类型
        // getGenericSuperclass()⽤来获取当前类的⽗类的类型
        // ParameterizedType表示的是带泛型的类型
        ParameterizedType parameterizedType = (ParameterizedType)
                clazz.getGenericSuperclass();
        // 获取具体的泛型类型 getActualTypeArguments获取具体的泛型的类型
        // 这个⽅法会返回⼀个Type的数组
        Type[] types = parameterizedType.getActualTypeArguments();
        // 获取具体的泛型的类型·
        this.type = (Class<T>) types[0];
    }

    private QueryRunner queryRunner = new QueryRunner();

    // 写操作（增删改）
    public int update(Connection conn, String sql, Object... params) {
        int count = 0;
        try {
            count = queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    // 查
    // 查 1 查一个对象
    public T getBean(Connection conn,String sql, Object... params) {
        T t = null;
        try {
            t = queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    // 查 2 查所有对象
    public List<T> getBeanList(Connection conn, String sql, Object... params) {
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(type),
                    params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
