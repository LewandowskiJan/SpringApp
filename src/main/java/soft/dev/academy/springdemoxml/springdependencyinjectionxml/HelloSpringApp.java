package soft.dev.academy.springdemoxml.springdependencyinjectionxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import soft.dev.academy.springdemoxml.Coach;


public class HelloSpringApp {


    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // let's call our new method for fortunes
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();

    }
}
