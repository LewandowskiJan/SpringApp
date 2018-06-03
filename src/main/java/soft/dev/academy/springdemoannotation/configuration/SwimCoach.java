package soft.dev.academy.springdemoannotation.configuration;

import soft.dev.academy.springdemoannotation.Coach;
import soft.dev.academy.springdemoannotation.FortuneService;

public class SwimCoach implements Coach {


    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
