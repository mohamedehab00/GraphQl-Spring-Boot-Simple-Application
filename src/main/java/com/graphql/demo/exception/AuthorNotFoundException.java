package com.graphql.demo.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Integer id) {
        super("Author with id: "+id+" is not found");
    }
}
