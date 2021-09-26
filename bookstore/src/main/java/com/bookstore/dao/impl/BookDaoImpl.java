package com.bookstore.dao.impl;

import com.bookstore.beans.Book;
import com.bookstore.beans.Page;
import com.bookstore.dao.BaseDao;
import com.bookstore.dao.BookDao;

import java.sql.Connection;
import java.util.List;

public class BookDaoImpl extends BaseDao<BookDao> implements BookDao {


    @Override
    public void saveBook(Connection conn, Book book) {

    }

    @Override
    public void deleteBookById(Connection conn, String bookId) {

    }

    @Override
    public void updateBook(Connection conn, Book book) {

    }

    @Override
    public List<Book> getBooks(Connection conn) {
        return null;
    }

    @Override
    public Book getBookById(Connection conn, String bookId) {
        return null;
    }

    @Override
    public Page<Book> getPageBooks(Connection conn, Page<Book> page) {
        return null;
    }

    @Override
    public Page<Book> getPageBooksByPrice(Connection conn, Page<Book> page, double minPrice, double maxPrice) {
        return null;
    }
}
