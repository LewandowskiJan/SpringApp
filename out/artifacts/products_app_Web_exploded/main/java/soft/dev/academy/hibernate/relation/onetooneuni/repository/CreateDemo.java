package soft.dev.academy.hibernate.relation.onetooneuni.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.onetooneuni.entity.Instructor;
import soft.dev.academy.hibernate.relation.onetooneuni.entity.InstructorDetail;


public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernateonetoone.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects
            /*
            Instructor tempInstructor =
                    new Instructor("Chad", "Darby", "darby@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.examplepage.com/youtube", "<3 2 Code!");
            */

            Instructor tempInstructor =
                    new Instructor("Name1", "Surname1", "example@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.page.com/youtube", "Best hobby!");

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
            factory.close();
        }

    }

}
