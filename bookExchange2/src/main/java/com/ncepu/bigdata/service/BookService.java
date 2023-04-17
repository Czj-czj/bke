package com.ncepu.bigdata.service;

import com.ncepu.bigdata.entity.Book;

import java.util.List;


public interface BookService {
    Book getBookById(int bookId);

    List<Book> getBookByRG(int start, int end);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBookById(int bookId);
}
