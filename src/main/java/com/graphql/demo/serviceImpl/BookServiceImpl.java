package com.graphql.demo.serviceImpl;

import com.graphql.demo.entity.Book;
import com.graphql.demo.exception.BookNotFoundException;
import com.graphql.demo.repository.BookJpaRepository;
import com.graphql.demo.service.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class BookServiceImpl implements BookService {
    private BookJpaRepository bookJpaRepository;

    @Autowired
    public void setBookJpaRepository(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return getBookJpaRepository().findAll();
    }

    @Override
    public List<Book> searchBooksByName(String nameLike) {
        return getBookJpaRepository().findAllByNameContainingIgnoreCase("%"+nameLike+"%");
    }

    @Override
    public Book getBookById(Integer id) {
        Optional<Book> book = getBookJpaRepository().findById(id);

        if (book.isEmpty()){
            throw  new BookNotFoundException(id);
        }

        return book.get();
    }
}
