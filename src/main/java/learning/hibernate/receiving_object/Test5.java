package learning.hibernate.receiving_object;

import learning.hibernate.save_object.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> emps = session
                .createQuery("from Employee where name='Oleg' AND salary > 474")
                .getResultList();
            for (Employee emp : emps) {
                System.out.println(emp);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
