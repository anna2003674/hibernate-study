package learning.hibernate.hibernate_test2.one_to_many.lazy_eager;

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
            Department department = new Department("Sales", 800, 1500);
            Employee emp1 = new Employee("Egor", "Tregulov", 850);
            Employee emp2 = new Employee("Mariya", "Sidorova", 1500);
            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            department.addEmployeeToDepartment(emp3);
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
