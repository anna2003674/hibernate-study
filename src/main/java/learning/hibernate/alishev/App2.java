package learning.hibernate.alishev;

import learning.hibernate.alishev.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Person.class)
            .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person1 = new Person("Oleg", 15);
            Person person2 = new Person("Igor", 18);
            Person person3 = new Person("Petr", 19);
            session.save(person1);
            session.save(person2);
            session.save(person3);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
