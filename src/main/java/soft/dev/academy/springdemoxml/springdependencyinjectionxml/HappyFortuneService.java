package soft.dev.academy.springdemoxml.springdependencyinjectionxml;

import soft.dev.academy.springdemoxml.FortuneService;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }

}
