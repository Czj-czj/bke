package com.ncepu.bigdata.mapper;

import com.ncepu.bigdata.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    @Select("SELECT * FROM Book WHERE Book_ID = #{bookID}")
    Book getBookByID(@Param("bookID") int bookID);

    @Select("SELECT * FROM Book WHERE Book_ID > #{start} limit #{end}")
    List<Book> getBookByRG(@Param("start") int start, @Param("end") int count);

    @Select("SELECT * FROM Book")
    List<Book> getAllBooks();

    @Insert("INSERT INTO Book (User_ID, Title, Author, Publisher, PublishDate, Description, Image) " +
            "VALUES (#{book.userID}, #{book.title}, #{book.author}, #{book.publisher}, " +
            "#{book.publishDate}, #{book.description}, #{book.image})")
    @Options(useGeneratedKeys = true, keyProperty = "book.bookID")
    void addBook(@Param("book") Book book);

    @Insert("INSERT INTO Book (User_ID, Title, Author, Publisher, PublishDate, Description, Image, Price) " +
            "VALUES (#{userID}, #{title}, #{author}, #{publisher}, #{publishDate}, #{description}, #{image}, #{price})")
    void add_Book(Integer userID, String title, String author, String publisher, String publishDate,
                  String description, String image, Double price);

    @Update("UPDATE Book SET Title = #{book.title}, Author = #{book.author}, " +
            "Publisher = #{book.publisher}, Publish_Date = #{book.publishDate}, " +
            "Description = #{book.description}, Image = #{book.image} " +
            "WHERE Book_ID = #{book.bookID}")
    void updateBook(@Param("book") Book book);

    @Delete("DELETE FROM Book WHERE Book_ID = #{bookID}")
    void deleteBook(@Param("bookID") int bookID);

//    @Select("select * from user where user_id = #{uid}")
//    User byId(int uid);
}

