package soft.dev.academy.hibernate.fetchtypes.eager.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.Course;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.Instructor;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.InstructorDetail;


public class EagerLazyDemo {

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

            System.out.println("\n\nInstructor: " + tempInstructor + "\n\n");

           // get course for instructor
            System.out.println("\n\nCourses: " + tempInstructor.getCourses()+ "\n\n");

            // commit transaction
            session.getTransaction().commit();

            System.out.println("\n\nDone! \n\n");

        } finally {

            // add clean up code
            // session.close();
            factory.close();
        }

    }

}
