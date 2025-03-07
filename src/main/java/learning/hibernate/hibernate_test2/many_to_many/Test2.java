package learning.hibernate.hibernate_test2.many_to_many;

import learning.hibernate.hibernate_test2.many_to_many.model.Child;
import learning.hibernate.hibernate_test2.many_to_many.model.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Section.class)
            .addAnnotatedClass(Child.class)
            .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Section section1 = new Section("Volleyball");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");
            Child child1 = new Child("Igor", 10);
            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);
            session.beginTransaction();
            session.save(child1);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
