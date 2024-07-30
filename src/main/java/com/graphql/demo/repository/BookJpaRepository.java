package com.graphql.demo.repository;

import com.graphql.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByNameContainingIgnoreCase(String nameLike);
}
