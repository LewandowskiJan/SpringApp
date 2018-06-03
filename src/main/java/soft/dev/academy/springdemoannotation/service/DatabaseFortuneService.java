package soft.dev.academy.springdemoannotation.service;

import org.springframework.stereotype.Component;
import soft.dev.academy.springdemoannotation.FortuneService;

@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
