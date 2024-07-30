package com.graphql.demo.controller;

import com.graphql.demo.entity.Book;
import com.graphql.demo.service.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Getter
@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    List<Book> books(){
        return getBookService().getAllBooks();
    }

    @QueryMapping
    Book bookById(@Argument Integer id){
        return getBookService().getBookById(id);
    }
}
