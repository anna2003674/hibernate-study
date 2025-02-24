package learning.hibernate.hibernate_test2.one_to_one;

import learning.hibernate.hibernate_test2.one_to_one.model.Detail;
import learning.hibernate.hibernate_test2.one_to_one.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Detail.class)
            .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 589);
            Detail detail = new Detail("New-York", "89209555226",
                "nikolay3454@gmail.com");
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(detail);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
