package ch.bfh.coffeeflash.camp;

import ch.bfh.coffeeflash.camp.config.ServiceConfiguration;
import ch.bfh.coffeeflash.camp.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args){


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
//        - With no config file -
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.scan("ch.bfh.coffeeflash.camp");
//        ctx.refresh();

        PartyService partyService = ctx.getBean(PartyService.class);
        partyService.createParty("Coffeflash");

        ctx.close();
    }
}
