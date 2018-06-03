package soft.dev.academy.springdemoannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {


    private FortuneServie fortuneServie;

    @Autowired
    public TennisCoach(FortuneServie theFortuneServie) {
        fortuneServie = theFortuneServie;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneServie.getFortune();
    }


}
