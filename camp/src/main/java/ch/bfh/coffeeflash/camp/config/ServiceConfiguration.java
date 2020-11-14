package ch.bfh.coffeeflash.camp.config;

import ch.bfh.coffeeflash.camp.service.HeroService;
import ch.bfh.coffeeflash.camp.service.HeroServiceImpl;
import ch.bfh.coffeeflash.camp.service.PartyService;
import ch.bfh.coffeeflash.camp.service.PartyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new HeroServiceImpl();
    }

    @Bean
    public PartyService partyService() {
        return new PartyServiceImpl();
    }

}
