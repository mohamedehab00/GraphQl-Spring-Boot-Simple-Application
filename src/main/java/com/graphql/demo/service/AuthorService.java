package com.graphql.demo.service;

import com.graphql.demo.entity.Author;

public interface AuthorService {
    Author getAuthorById(Integer id);
}
