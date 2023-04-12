package com.ncepu.bigdata.service.serviceImpl;
import com.ncepu.bigdata.entity.Book;
import com.ncepu.bigdata.mapper.BookMapper;
import com.ncepu.bigdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getBookById(int bookId) {
        return bookMapper.getBookByID(bookId);
    }

    @Override
    public Book getBookByRG(int start, int end) {
        return bookMapper.getBookByRG(start,end);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
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
