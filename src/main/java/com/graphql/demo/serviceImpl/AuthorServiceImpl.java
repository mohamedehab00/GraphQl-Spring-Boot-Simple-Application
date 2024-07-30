package com.graphql.demo.serviceImpl;

import com.graphql.demo.entity.Author;
import com.graphql.demo.exception.AuthorNotFoundException;
import com.graphql.demo.repository.AuthorJpaRepository;
import com.graphql.demo.service.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorJpaRepository authorJpaRepository;

    @Autowired
    public void setAuthorJpaRepository(AuthorJpaRepository authorJpaRepository) {
        this.authorJpaRepository = authorJpaRepository;
    }

    @Override
    public Author getAuthorById(Integer id) {
        Optional<Author> author = getAuthorJpaRepository().findById(id);

        if (author.isEmpty()){
            throw new AuthorNotFoundException(id);
        }

        return author.get();
    }
}
