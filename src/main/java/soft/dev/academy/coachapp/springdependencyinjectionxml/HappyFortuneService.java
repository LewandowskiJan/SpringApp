package soft.dev.academy.coachapp.springdependencyinjectionxml;

import soft.dev.academy.coachapp.FortuneService;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }

}
