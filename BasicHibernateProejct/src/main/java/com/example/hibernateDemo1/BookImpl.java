package com.example.hibernateDemo1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookImpl implements BookInterface {
	
	Session session=HibernateUtility.getSessionFactory().openSession();
	Transaction transaction=null;

	public void addBook(Book book)
	{
		
		try
		{
			transaction =session.beginTransaction();
			session.save(book);
			transaction.commit();
		}
		catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public List<Book> getBook() {
		
		List<Book>books=session.createQuery("from Book",Book.class).list();
		
		return books;
	}

	@Override
	public void updateBook(Book book) {
		
		transaction =session.beginTransaction();
		Book existingBook=session.get(Book.class,book.getId());
		
		if(existingBook!=null)
		{
			existingBook.setTitle(book.getTitle());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setPrice(book.getPrice());
			session.update(existingBook);
		}
		
		transaction.commit();	
	}

	@Override
	public void deleteById(int id) {
		transaction=session.beginTransaction();
		
		Book book=session.get(Book.class,id);
		if(book!=null)
		{
			session.delete(book);
		}
		transaction.commit();
		
		
	}

	@Override
	public Book getBookById(int id) {
		
		Book bk=session.get(Book.class, id);
		
		 return(bk);
		
	}
}
