package learning.hibernate.hibernate_test2.one_to_many.lazy_eager;

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
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class, 2);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
