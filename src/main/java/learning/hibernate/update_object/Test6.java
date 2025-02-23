package learning.hibernate.update_object;

import learning.hibernate.save_object.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test6 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            System.out.println(emp);
            emp.setSalary(1500);
            session.getTransaction().commit();
            System.out.println(emp);
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
