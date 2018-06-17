package soft.dev.academy.hibernate.relation.manytomany.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.manytomany.entity.*;


public class DeleteMaryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernatemanytomany.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the student mary from database
            int studentId = 2;
            Student student = session.get(Student.class, studentId);

            System.out.println("\nLoad student: " + student + "\n");
            System.out.println("\nCourses: " + student.getCourses() + "\n");

            System.out.println("\nDeleteting student: " + student);
            session.delete(student);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            // add clean up code
            // session.close();
            factory.close();
        }

    }

}
