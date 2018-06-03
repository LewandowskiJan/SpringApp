package soft.dev.academy.springdemoannotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneServie {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
