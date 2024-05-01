import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.model.Item;
import org.model.Person;

import java.util.ArrayList;
import java.util.Collections;

public class App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session= sessionFactory.getCurrentSession();

		try{
			session.beginTransaction();

			Person person = new Person("Martin-Cascading-final",90);
			person.addItems(new Item("Cascading item1"));
			person.addItems(new Item("Cascading item2"));
			person.addItems(new Item("Cascading item3"));

			session.save(person);//session.save(item) сделает сам hibernate

			session.getTransaction().commit();
		}finally {
			sessionFactory.close();
		}
	}
}
