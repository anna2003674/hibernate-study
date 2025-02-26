package learning.hibernate.hibernate_test2.many_to_many;

import learning.hibernate.hibernate_test2.many_to_many.model.Child;
import learning.hibernate.hibernate_test2.many_to_many.model.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Section.class)
            .addAnnotatedClass(Child.class)
            .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Section section1 = new Section("Football");
            Child child1 = new Child("Zaur", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasya", 6);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();
            session.save(section1);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
