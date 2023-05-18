package com.ncepu.bigdata.service;

import com.ncepu.bigdata.entity.Book;

import java.util.List;


public interface BookService {
    Book getBookById(int bookId);

    List<Book> getBookByRG(int start, int count);

    void addBook(Book book);

    void add_Book(Integer userID, String title, String author, String publisher, String publishDate,
                  String description, String image, Double price);

    void updateBook(Book book);

    void deleteBookById(int bookId);
}
