package soft.dev.academy.coachapp.springbeanscopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import soft.dev.academy.coachapp.springdependencyinjectionxml.CricketCoach;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        //call our new methods to get the literal values
        System.out.println(theCoach.getEmailAddress());

        System.out.println(theCoach.getTeam());

        // close context
        context.close();

    }

}
