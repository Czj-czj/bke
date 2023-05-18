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
    public List<Book> getBooks(@RequestParam("start") int start, @RequestParam("count") int count) {
        List<Book> bookList = bookService.getBookByRG(start, count);
        return bookList;
    }

    @GetMapping("/add")
    public String addBook(@RequestParam("book") Book book) {
        bookService.addBook(book);
        return "success";
    }

    @GetMapping("addBook")
    public String addBook(
            @RequestParam("user_ID") int userID,
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("publisher") String publisher,
            @RequestParam("publishDate") String publishDate,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("image") String image
    ) {
        bookService.add_Book(userID, title, author, publisher, publishDate, description, image, price);
        return "success";
    }

    @PutMapping("/{bookId}")
    @ResponseBody
    public String updateBook(@PathVariable int bookId, @RequestBody Book book) {
        book.setBook_ID(bookId);
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
