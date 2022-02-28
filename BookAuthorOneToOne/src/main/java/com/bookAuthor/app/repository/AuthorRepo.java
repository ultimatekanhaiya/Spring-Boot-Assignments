package com.bookAuthor.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookAuthor.app.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
