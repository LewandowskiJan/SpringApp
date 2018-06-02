package soft.dev.academy.coachapp.springbeanscopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import soft.dev.academy.coachapp.Coach;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        // close context
        context.close();
    }
}
