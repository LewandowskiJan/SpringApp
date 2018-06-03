package soft.dev.academy.springdemoannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements Coach {


    @Qualifier("randomFortuneService")
    @Autowired
    private FortuneService fortuneService;

    // define a default constructor

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define a setter method - setter injection
    /*
    @Autowired
    public void setFortuneServie(FortuneServie theFortuneServie) {
        this.fortuneServie = theFortuneServie;
    }
    */

    // define a method, method injection
    /*
    @Autowired
    public void doSomeCrazyStuff(FortuneServie theFortuneServie) {
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff method");
        this.fortuneServie = theFortuneServie;
    }
    */

    // constructor injection
    /*
    @Autowired
    public TennisCoach(FortuneServie theFortuneServie) {
        fortuneServie = theFortuneServie;
    }
    */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
