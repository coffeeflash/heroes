package ch.bfh.coffeeflash.camp;

import ch.bfh.coffeeflash.camp.service.HeroService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("ch.bfh.coffeeflash.camp");
        ctx.refresh();

        HeroService heroService = ctx.getBean(HeroService.class);

        for (int i = 0; i < 10; i++) {
            heroService.createHero("Hero" + i);
        }

        ctx.close();
    }
}
