package learning.hibernate.hibernate_test2.one_to_many;

import learning.hibernate.hibernate_test2.one_to_many.model.Department;
import learning.hibernate.hibernate_test2.one_to_many.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Department.class)
            .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}