package com.bookAuthor.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookAuthor.app.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	
	//Derived Query Methods
	public Book findByAuthor(int authorId);
	
//	@Query("select u from Book  u")
//	public List<Book> findBooks();
	
}
