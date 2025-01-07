package com.example.hibernateDemo1;

import java.util.List;

public interface BookInterface {
	
    void addBook(Book book);
    List<Book>getBook();
	void updateBook(Book book);
	void deleteById(int id);
	Book getBookById(int id);

}
