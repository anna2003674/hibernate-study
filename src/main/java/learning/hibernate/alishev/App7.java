package learning.hibernate.alishev;

import learning.hibernate.alishev.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App7 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Person.class)
            .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.createQuery("UPDATE Person SET name='Test' WHERE age < 30").executeUpdate();
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
