package soft.dev.academy.coachapp.springbeanscopes;

import soft.dev.academy.coachapp.Coach;
import soft.dev.academy.coachapp.FortuneService;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public SwimCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 60 distances";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    // add an init method
    public void doMyStartupStuff(){
        System.out.println("SwimCoach: inside method doMyStartupStuff");
    }

    // add a destroy method
    public void doMyCleanupStuff(){
        System.out.println("SwimCoach: inside method doMyCleanupStuff");
    }
}
