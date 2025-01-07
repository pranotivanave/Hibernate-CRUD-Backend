package com.example.hibernateDemo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookMain {
	
	public static void main(String[] args) {
		
		Session session=HibernateUtility.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		

		BookInterface b=new BookImpl();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			
			System.out.println("enter you choce: ");
			System.out.println("1.Add Books");
			System.out.println("2.Get BookById");
			System.out.println("3.GetAll Books");
			System.out.println("4.UpdateBook");
			System.out.println("5.DeleteBook");
			System.out.println("6.Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				
				System.out.println("enter the book id:");
				int id=sc.nextInt();
				
				System.out.println("enter the title");
				String title=sc.next();
				
				System.out.println("enter author");
				String author=sc.next();
				
				System.out.println("enter the price");
				Double price=sc.nextDouble();
				
				Book book=new Book(id,title,author,price);
			   b.addBook(book);
				
				System.out.println("Book saved successfully!");
				break;
				
			case 2:
				
				
				System.out.println("enter id to get Book");
				int getBookId=sc.nextInt();
				Book bkget=b.getBookById(getBookId);
				
				if(bkget!=null)
				{
					System.out.println(" Book Found ");
					System.out.println(bkget);
				}
				else
				{
					System.out.println("Book not found");
				}
				
				break;
				
			case 3:
				
				
				System.out.println("All Book Details");
				List<Book>store= b.getBook();
				for(Book bk:store)
				{
					System.out.println(bk);
				}
				break;
			case 4:
				
				System.out.println("enter if to delete book");
				int deleteId=sc.nextInt();
                b.deleteById(deleteId);
                System.out.println("deleted Successfully..");
				
                break;
                
			case 5:
				

				System.out.println("---Update Book---");
				System.out.println("enter id");
				int upId=sc.nextInt();
				System.out.println("enter title");
				String upTitle=sc.next();
				System.out.println("enter author");
				String upAuthor=sc.next();
				System.out.println("enter price");
				double upPrice=sc.nextDouble();
				
				Book updated=new Book(upId,upTitle,upAuthor,upPrice);
				b.updateBook(updated);
				System.out.println("Book updated successfully!");
				break;
				
				
			case 6:
				
				System.exit(0);
				System.out.println("successfully exited");
				break;
				default:
					System.out.println("Invalid choice ...");
			}
		}
			
		
		
	}

}
