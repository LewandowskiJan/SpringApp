package soft.dev.academy.hibernate.fetchtypes.eager.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.Course;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.Instructor;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.InstructorDetail;


public class CreateInstructorDemo {

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

            // create the objects
            Instructor tempInstructor =
                    new Instructor("Susan", "Public", "example@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.youtube.com", "Video games");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();


            // save the instructor

            // Note: this will ALSO save the details object
            // because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

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
