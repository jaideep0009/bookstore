package doa.bookstore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.bookstore.Bookstore;

public class BookStoreDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("my-persistence-unit");
	Bookstore b=new Bookstore();
	
	public Bookstore add(Bookstore b)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(b);
		et.commit();
		return b;
		
	}
	
	public Bookstore findBy(int bookId)
	{
		EntityManager em=emf.createEntityManager();
		 b=em.find(Bookstore.class,bookId);
		 return b;
	}
	
	public Bookstore update(Bookstore b)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(b);
		et.commit();
		return b;
	}
	
	public Bookstore remove(int bookId)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		b=em.find(Bookstore.class,bookId);
		if(b!=null)
		{
			em.remove(b);
		}
		et.commit();
		return b;
	}
	
	public List<Bookstore> list()
	{
		EntityManager em=emf.createEntityManager();
		List<Bookstore> list=em.createQuery("select b from Bookstore b",Bookstore.class).getResultList();
		return list;
	}
	
}
