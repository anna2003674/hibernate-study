package learning.hibernate.hibernate_test2;

import learning.hibernate.hibernate_test2.model.Detail;
import learning.hibernate.hibernate_test2.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Detail.class)
            .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Zaur", "Tregulov", "IT", 800);
            Detail detail = new Detail("Baku", "89209567565",
                "zaurtregulov3676@gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
