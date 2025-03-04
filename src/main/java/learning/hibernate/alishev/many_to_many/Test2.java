package learning.hibernate.alishev.many_to_many;

import learning.hibernate.alishev.many_to_many.entity.Actor;
import learning.hibernate.alishev.many_to_many.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Movie.class)
            .addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Movie movie = session.get(Movie.class, 1);
            System.out.println(movie.getActors());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
