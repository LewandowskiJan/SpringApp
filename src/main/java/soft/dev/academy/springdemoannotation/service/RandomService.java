package soft.dev.academy.springdemoannotation.service;

import org.springframework.stereotype.Component;
import soft.dev.academy.springdemoannotation.FortuneServie;

@Component
public class RandomService implements FortuneServie {

    @Override
    public String getFortune() {
        return null;
    }
}
