package soft.dev.academy.springdemoannotation.configuration;

import soft.dev.academy.springdemoannotation.FortuneService;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is a sad day";
    }
}
