package com.ncepu.bigdata.service;

import com.ncepu.bigdata.entity.Book;


public interface BookService {
    Book getBookById(int bookId);
    Book getBookByRG(int start,int end);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBookById(int bookId);
}
