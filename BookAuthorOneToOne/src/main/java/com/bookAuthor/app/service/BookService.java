package com.bookAuthor.app.service;

import java.util.List;


import com.bookAuthor.app.entity.Book;
import com.bookAuthor.app.exception.bookException.bookServiceException.BookIdNotFoundException;


public interface BookService {
	
	public Book getBookById(int bookId) throws BookIdNotFoundException;

	public List<Book> getAllBooks();

	public Book getBookByAuthorId(int authorId);

	public Book getBookByAuthorName(String authorName);

	public Book setBook(Book book, int bookId);

	public void deleteBook(int bookId);

	public Book addBook(Book book, int authorId);

}
