package soft.dev.academy.hibernate.relation.manytomany.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.manytomany.entity.*;


public class CreateCourseAndStudentsDemo {

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

            // create a course
            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            // save the course
            System.out.println("\nSaving the course ... \n");
            session.save(tempCourse);
            System.out.println("\nSaved the course: " + tempCourse + "\n");

            // create the students
            Student student1 = new Student("Joe", "Doe", "joe@email.com");
            Student student2 = new Student("Mary", "Public", "mary@email.com");

            // add students to the course
            tempCourse.addStudent(student1);
            tempCourse.addStudent(student2);

            // save the students
            System.out.println("\nSaving students ...\n");
            session.save(student1);
            session.save(student2);
            System.out.println("\nSaved students: " + tempCourse.getStudents() + "\n");

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
