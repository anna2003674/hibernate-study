package learning.hibernate.alishev.many_to_many;

import learning.hibernate.alishev.many_to_many.entity.Actor;
import learning.hibernate.alishev.many_to_many.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Movie.class)
            .addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Movie movie = new Movie("Pupil fiction", 1994);
            Actor actor1 = new Actor("Harvey Keitel", 81);
            Actor actor2 = new Actor("Samuel L. Jackson", 81);
            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            session.save(movie);
            session.save(actor1);
            session.save(actor2);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
