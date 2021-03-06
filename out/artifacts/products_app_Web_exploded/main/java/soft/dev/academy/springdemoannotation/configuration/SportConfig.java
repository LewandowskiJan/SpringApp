package soft.dev.academy.springdemoannotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import soft.dev.academy.springdemoannotation.Coach;
import soft.dev.academy.springdemoannotation.FortuneService;

@Configuration
//@ComponentScan("soft.dev.academy.springdemoannotation")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach(){
       return new SwimCoach(sadFortuneService());
    }

}
