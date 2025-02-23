package learning.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("Hibernate session успешно создан!");

        session.beginTransaction();
        session.save(User.builder()
            .username("ivan@mail.ru")
            .firstname("Ivan")
            .lastname("Ivanov")
            .birthDate(LocalDate.of(2000, 01, 01))
            .age(23)
            .build());
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
