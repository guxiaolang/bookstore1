package com.bookstore.dao;

import com.bookstore.beans.Book;
import com.bookstore.beans.Page;

import java.sql.Connection;
import java.util.List;

public interface BookDao {
    // 增
    void saveBook(Connection conn, Book book);
    // 删
    void deleteBookById(Connection conn,String bookId);
    // 改
    void updateBook(Connection conn,Book book);
    // 查
    // 查1 查所有书
    List<Book> getBooks(Connection conn);
    // 查2 查一本书
    Book getBookById(Connection conn,String bookId);
    // 查3 根据页面查书
    Page<Book> getPageBooks(Connection conn, Page<Book> page);
    // 查4 根据页面也价钱查书
    Page<Book> getPageBooksByPrice(Connection conn,Page<Book> page, double
            minPrice, double maxPrice);


}
