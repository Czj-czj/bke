package com.ncepu.bigdata.controller;

import com.ncepu.bigdata.entity.Book;
import com.ncepu.bigdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/book")
public class BookAction {
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    @ResponseBody
    public Book getBook(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/getBook")
    public List<Book> getBooks(@RequestParam("start") int start,@RequestParam("end") int end){
        List<Book> bookList = bookService.getBookByRG(start, end);
        return bookList;
    }
    @PostMapping("/add")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "success";
    }

    @PutMapping("/{bookId}")
    @ResponseBody
    public String updateBook(@PathVariable int bookId, @RequestBody Book book) {
        book.setBookID(bookId);
        bookService.updateBook(book);
        return "success";
    }

    @DeleteMapping("/{bookId}")
    @ResponseBody
    public String deleteBook(@PathVariable int bookId) {
        bookService.deleteBookById(bookId);
        return "success";
    }
}
