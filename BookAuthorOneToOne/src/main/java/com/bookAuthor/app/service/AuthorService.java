package com.bookAuthor.app.service;

import java.util.List;

import com.bookAuthor.app.entity.Author;


public interface AuthorService {
	public Author addAuthor(Author author);

	public List<Author> getAuthors();
}
