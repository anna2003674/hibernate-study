package learning.hibernate.hibernate_test2.one_to_many;

import learning.hibernate.hibernate_test2.one_to_many.model.Department;
import learning.hibernate.hibernate_test2.one_to_many.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Department.class)
            .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Department department = new Department("IT", 300, 1200);
            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
            Employee emp2 = new Employee("Elena", "Sidorova", 1000);
            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
