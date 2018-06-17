package soft.dev.academy.hibernate.relation.manytomany.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.manytomany.entity.Course;
import soft.dev.academy.hibernate.relation.manytomany.entity.InstructorDetail;
import soft.dev.academy.hibernate.relation.manytomany.entity.Review;
import soft.dev.academy.hibernate.relation.manytomany.entity.Instructor;


public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernatemanytomany.cfg.xml")
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

            // create a course
            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            // add some reviews
            tempCourse.addReview(new Review("Greate course ... loved it"));
            tempCourse.addReview(new Review("Cool course, job well done"));
            tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

            // save the course ... and leverage the cascade all
            System.out.println("\nSaving the course");
            System.out.println("\n" + tempCourse);
            System.out.println("\n" + tempCourse.getReviews());
            session.save(tempCourse);

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
