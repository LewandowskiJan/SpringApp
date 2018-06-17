package soft.dev.academy.hibernate.relation.onetomanyuni.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.onetomanyuni.entity.Course;
import soft.dev.academy.hibernate.relation.onetomanyuni.entity.Instructor;
import soft.dev.academy.hibernate.relation.onetomanyuni.entity.InstructorDetail;
import soft.dev.academy.hibernate.relation.onetomanyuni.entity.Review;


public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernateonetomanyuni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            // print the course
            System.out.println("\n" + tempCourse + "\n");

            // print the course reviews
            System.out.println("\n" + tempCourse.getReviews() + "\n");

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
