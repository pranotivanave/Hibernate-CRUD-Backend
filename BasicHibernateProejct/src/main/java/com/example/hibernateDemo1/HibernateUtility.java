package com.example.hibernateDemo1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
private static SessionFactory sessionFactory;


static{
	try {
		
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


public static SessionFactory getSessionFactory()
{
return sessionFactory;	
}
	
}
