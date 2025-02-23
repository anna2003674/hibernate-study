package learning.hibernate.receiving_object;

import learning.hibernate.save_object.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Oleg", "Popov", "HR", 700);
            session.beginTransaction();
            session.save(emp);

            int myId = emp.getId();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
