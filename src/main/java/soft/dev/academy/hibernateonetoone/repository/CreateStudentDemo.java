package soft.dev.academy.hibernateonetoone.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.demo.entity.Student;


public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernateonetoone.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            //create a student object
            System.out.println("Creatig new student object...");
            Student tempStudent = new Student("Paul", "Wall", "paul@email.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("done");

        } finally {
            factory.close();
        }

    }

}