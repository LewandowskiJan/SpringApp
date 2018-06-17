package soft.dev.academy.hibernate.relation.demo.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.demo.entity.Student;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").list();

            // display the students
            displayStudents(theStudents);

            // query students: lastName = 'Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

            // display the students
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);

            //query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'" ).list();
            System.out.println("\n\nStudents who have last name of Doe OR first name of Daffy");
            displayStudents(theStudents);

            //gueary students where email LIKE '%email.com'
            theStudents = session.createQuery("from Student s where s.email LIKE '%email.com'").list();
            displayStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("done");

        } finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

}
