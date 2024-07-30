package com.graphql.demo.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Integer id) {
        super("Book with id : "+id+" is not found");
    }
}
