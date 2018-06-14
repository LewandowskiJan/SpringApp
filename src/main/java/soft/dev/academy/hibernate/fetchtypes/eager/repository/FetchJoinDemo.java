package soft.dev.academy.hibernate.fetchtypes.eager.repository;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.Course;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.Instructor;
import soft.dev.academy.hibernate.fetchtypes.eager.entity.InstructorDetail;


public class FetchJoinDemo {

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

            // option 2: Hibernate query with HQL

            // get the instructor from db
            int theId = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "where i.id=:theInstructorId", Instructor.class);

            // set parameter on query
            query.setParameter("theInstructorId", theId);

            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("The session is now closed! \n");


            // get course for instructor
            System.out.println("\n\nInstructor: " + tempInstructor.getCourses() + "\n\n");
            System.out.println("\n\nDone! \n\n");



        } finally{

            // add clean up code
            // session.close();
            factory.close();
        }

    }

}
