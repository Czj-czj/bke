package com.ncepu.bigdata.service.serviceImpl;

import com.ncepu.bigdata.entity.Book;
import com.ncepu.bigdata.mapper.BookMapper;
import com.ncepu.bigdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getBookById(int bookId) {
        return bookMapper.getBookByID(bookId);
    }

    @Override
    public List<Book> getBookByRG(int start, int count) {
        return bookMapper.getBookByRG(start, count);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void add_Book(Integer userID, String title, String author, String publisher, String publishDate,
                         String description, String image, Double price) {
        bookMapper.add_Book(userID, title, author, publisher, publishDate, description, image, price);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBookById(int bookId) {
        bookMapper.deleteBook(bookId);
    }
}
