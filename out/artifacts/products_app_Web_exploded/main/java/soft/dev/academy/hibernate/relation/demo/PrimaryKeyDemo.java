package soft.dev.academy.hibernate.relation.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import soft.dev.academy.hibernate.relation.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            //create 3 student object
            System.out.println("Creatig 3 student object...");
            Student tempStudent1 = new Student("Joe", "Doe", "joe@email.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@email.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@email.com");
            Student tempStudent4 = new Student("Daffy", "Applebum", "daffy@email.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.save(tempStudent4);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("done");

        } finally {
            factory.close();
        }

    }


}

