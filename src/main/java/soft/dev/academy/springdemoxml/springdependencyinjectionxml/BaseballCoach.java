package soft.dev.academy.springdemoxml.springdependencyinjectionxml;

import soft.dev.academy.springdemoxml.Coach;
import soft.dev.academy.springdemoxml.FortuneService;

public class BaseballCoach implements Coach {

    // define a private field for the dependency
    private FortuneService fortuneService;

    // define a constructor for dependency injection
    public BaseballCoach(FortuneService theFourtuneService) {
    fortuneService = theFourtuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on battingpractice";
    }

    @Override
    public String getDailyFortune() {

        // use my fortuneService to get fortune
        return fortuneService.getFortune();
    }
}
