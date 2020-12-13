package com.src;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta =new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		//new customer
		Customer c=new Customer();
		c.setCid(121);
		c.setCname("hari");
		c.setCadd("goa");
		c.setEmailid("abc.com");
		
		//apending
		//session.save(c);
		//session.delete(c);
		session.merge(c);
		t.commit();
		
		//closing
		session.close();
		factory.close();
		
		System.out.println("deleted!");
	}

}