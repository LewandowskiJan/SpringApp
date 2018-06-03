package soft.dev.academy.springdemoannotation.service;

import org.springframework.stereotype.Component;
import soft.dev.academy.springdemoannotation.FortuneService;

@Component
public class RESTFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
