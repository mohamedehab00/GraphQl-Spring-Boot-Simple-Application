package com.graphql.demo.controller;

import com.graphql.demo.entity.Author;
import com.graphql.demo.service.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Getter
@Controller
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public Author authorById(@Argument Integer id){
        return getAuthorService().getAuthorById(id);
    }
}
