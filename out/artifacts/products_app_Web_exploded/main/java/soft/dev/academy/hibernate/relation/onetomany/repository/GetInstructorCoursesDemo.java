package soft.dev.academy.hibernate.relation.onetomany.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.onetomany.entity.Course;
import soft.dev.academy.hibernate.relation.onetomany.entity.Instructor;
import soft.dev.academy.hibernate.relation.onetomany.entity.InstructorDetail;


public class GetInstructorCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernateonetomany.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Instructor: " + tempInstructor);

           // get course for instructor
            System.out.println("Courses: " + tempInstructor.getCourses());

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
