package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main( String[] args ) { //Configuration по умолчанию читает конфигурацию из hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//
//            List<Item> items=person.getItems();
//            System.out.println(items);

//            Item item = session.get(Item.class, 2);
//            System.out.println(item);
//            Person person = item.getOwner();
//
//            System.out.println(person);
//            Person person= session.get(Person.class, 3);

//            Item itemFromHibernate = new Item("New Hibernate Item", person);
//            Person person =new Person("New Person", 17);
//            Item newItem = new Item("item", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//
//            session.save(person);
//            session.save(newItem);
//            Person person = session.get(Person.class, 2);
//            List<Item> items = person.getItems();

            Person person = session.get(Person.class,4);
            Item item = session.get(Item.class, 1);
            //for Cache
            item.getOwner().getItems().remove(item);
            //SQL
            item.setOwner(person);
            //for Cache
            person.getItems().add(item);





            //SQL to delete items
//            for (Item item:items) {
//                session.remove(item);
//            }
            //no SQL, but need to delete elements from Сache.
//            person.getItems().clear();

//            session.save(newPerson);
//            List<Person> people= session.createQuery("from Person ").getResultList();
//            people.stream().forEach(p -> System.out.println(p));

//            session.createQuery("update Person set name='Test' where age=8").executeUpdate();
//            List<Person> people=session.createQuery("from Person ").getResultList();
//            people.stream().forEach(person -> System.out.println(person));
//            session.createQuery("delete from Person where name='Test' ").executeUpdate();
            session.getTransaction().commit();


        }finally {
            sessionFactory.close();
        }
    }
}
