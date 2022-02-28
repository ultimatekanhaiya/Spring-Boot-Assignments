package com.bookAuthor.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookAuthor.app.entity.Author;
import com.bookAuthor.app.repository.AuthorRepo;
import com.bookAuthor.app.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepo authorRepo;

	@Override
	public Author addAuthor(Author author) {
		authorRepo.save(author);
		return author;
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepo.findAll();
	}
	
}
