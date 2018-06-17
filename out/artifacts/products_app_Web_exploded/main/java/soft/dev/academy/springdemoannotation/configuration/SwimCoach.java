package soft.dev.academy.springdemoannotation.configuration;

import org.springframework.beans.factory.annotation.Value;
import soft.dev.academy.springdemoannotation.Coach;
import soft.dev.academy.springdemoannotation.FortuneService;

public class SwimCoach implements Coach {


    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

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

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
