package com.bookAuthor.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookAuthor.app.entity.Book;
import com.bookAuthor.app.exception.bookException.bookServiceException.BookIdNotFoundException;
import com.bookAuthor.app.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/book/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable("bookId") int bookId) {
		try {
			Book book = bookService.getBookById(bookId);
			return new ResponseEntity<Book>(book, HttpStatus.OK);

		} catch (BookIdNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	//not working
	@GetMapping("/book1/{authorId}")
	public Book getBookByAuthorId(@PathVariable("authorId") int authorId) {
		return bookService.getBookByAuthorId(authorId);
	}

	// not completed
	@GetMapping("/book2/{authorName}")
	public Book getBookByAuthorName(@PathVariable("authorName") String authorName) {
		return bookService.getBookByAuthorName(authorName);
	}

	// not completed
	@PutMapping("/book/{bookId}")
	public Book setBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		return bookService.setBook(book, bookId);
	}

	@DeleteMapping("/book/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
	}

	@PostMapping("/book/{authorId}")
	public Book addBook(@RequestBody Book book, @PathVariable("authorId") int authorId) {
		return bookService.addBook(book, authorId);
	}
}
