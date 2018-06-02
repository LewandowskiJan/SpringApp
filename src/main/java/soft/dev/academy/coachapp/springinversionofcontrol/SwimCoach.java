package soft.dev.academy.coachapp.springinversionofcontrol;

import soft.dev.academy.coachapp.Coach;

public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim 60 distances";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
