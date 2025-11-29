package bookstore.demo;

import java.util.List;

import com.bookstore.Bookstore;

import doa.bookstore.BookStoreDao;

public class BookStoreDemo {

	public static void main(String[] args) {
		
		Bookstore b1=new Bookstore(101,"godan","premchand",499,"xyz");
		Bookstore b2=new Bookstore(102,"harrypotter","jk rolling",1113,"xyx");
		Bookstore b3=new Bookstore(103,"rashmirathi","rs dinkar",3441,"xzy");
		
		BookStoreDao d=new BookStoreDao();
		d.add(b1);
		d.add(b2);
		d.add(b3);
		System.out.println("created succesfully");
		
		System.out.println(d.findBy(103));
		
		Bookstore b=d.remove(103);
		System.out.println(b);
		
		b2.setPrice(699);
		d.update(b2);
		System.out.println("updated price ="+b2.getPrice());
		
		List<Bookstore> list= d.list();
		for (Bookstore bookstore : list) {
			System.out.println(bookstore);
		}
		
		

	}

}
