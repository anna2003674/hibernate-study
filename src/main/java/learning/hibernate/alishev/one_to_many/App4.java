package learning.hibernate.alishev.one_to_many;

import learning.hibernate.alishev.one_to_many.entity.Item;
import learning.hibernate.alishev.one_to_many.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

public class App4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Person.class)
            .addAnnotatedClass(Item.class)
            .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = new Person("Test person", 30);
            Item newItem = new Item("Item from Hibernate 2", person);
            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
            session.save(person);
            session.save(newItem);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
