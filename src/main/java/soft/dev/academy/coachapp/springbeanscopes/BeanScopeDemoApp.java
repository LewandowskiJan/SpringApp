package soft.dev.academy.coachapp.springbeanscopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import soft.dev.academy.coachapp.Coach;


public class BeanScopeDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same (beans)

        boolean result = (theCoach == alphaCoach);

        //print out the results
        System.out.println("\nPointing to the same object " + result);
        System.out.println("\nMemory location for theCoach:  " + theCoach);
        System.out.println("\nMemory location for alphaCoach:  " + alphaCoach);

        // close context
        context.close();

    }

}
