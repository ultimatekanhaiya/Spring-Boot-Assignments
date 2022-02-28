package com.bookAuthor.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookAuthor.app.entity.Author;
import com.bookAuthor.app.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	
	@GetMapping("/authors")
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}
	
	@PostMapping("/author")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
}
