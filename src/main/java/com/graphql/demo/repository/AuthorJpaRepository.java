package com.graphql.demo.repository;

import com.graphql.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorJpaRepository extends JpaRepository<Author, Integer> {
}
