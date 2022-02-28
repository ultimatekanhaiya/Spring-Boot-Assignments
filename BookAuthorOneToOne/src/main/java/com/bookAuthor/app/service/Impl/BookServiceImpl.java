package com.bookAuthor.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookAuthor.app.entity.Author;
import com.bookAuthor.app.entity.Book;
import com.bookAuthor.app.exception.bookException.bookServiceException.BookIdNotFoundException;
import com.bookAuthor.app.repository.AuthorRepo;
import com.bookAuthor.app.repository.BookRepo;
import com.bookAuthor.app.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private AuthorRepo authorRepo;

	@Override
	public Book getBookById(int bookId) throws BookIdNotFoundException {
		Optional<Book> optional = bookRepo.findById(bookId);
		Book book = optional.get();
		if(book == null)
			throw new BookIdNotFoundException("BookId " + bookId  + " not found");
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = bookRepo.findAll();
		//list.forEach(b -> System.out.println(b));
		return list;
	}

	@Override
	public Book getBookByAuthorId(int authorId) {
		Book result = bookRepo.findByAuthor(authorId);
		return result;
	}

	@Override
	public Book getBookByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book setBook(Book book, int bookId) {
		Optional<Book> optional  = bookRepo.findById(bookId);
		Book book2 = optional.get();
		book2.setTitle(book.getTitle());
		book2.setAuthor(book.getAuthor());
		bookRepo.save(book2);
		return book2;
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepo.deleteById(bookId);
		//System.out.println("deleted");
	}

	@Override
	public Book addBook(Book book, int authorId) {
		Optional<Author> optional = authorRepo.findById(authorId);
		Author auth = optional.get();
		book.setAuthor(auth);
		bookRepo.save(book);
		return book;
	}

}
