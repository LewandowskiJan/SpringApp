package soft.dev.academy.hibernate.relation.manytomany.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.manytomany.entity.*;


public class AddCourseForMaryDemo {

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

            // create more courses
            Course course1 = new Course("Rubik's Cube - How to Speed Cube");
            Course course2 = new Course("Atari 2600 - Game Development");

            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);

            //save the course
            System.out.println("\nSaved the courses: ... \n");
            session.save(course1);
            session.save(course2);
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
