package com.graphql.demo.service;

import com.graphql.demo.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Integer id);

    List<Book> searchBooksByName(String nameLike);
}
