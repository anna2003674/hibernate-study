package learning.hibernate.alishev.one_to_many;

import learning.hibernate.alishev.one_to_many.entity.Item;
import learning.hibernate.alishev.one_to_many.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Person.class)
            .addAnnotatedClass(Item.class)
            .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Item item = session.get(Item.class, 5);
            System.out.println(item);

            Person person = item.getOwner();
            System.out.println(person);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

