package learning.hibernate.alishev;

import learning.hibernate.alishev.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Person.class)
            .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Person person = session.get(Person.class, 1);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        session.getTransaction().commit();
    }
}
