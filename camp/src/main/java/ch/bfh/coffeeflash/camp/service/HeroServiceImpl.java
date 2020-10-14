package ch.bfh.coffeeflash.camp.service;

import ch.bfh.coffeeflash.camp.model.Hero;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService{

    public Hero createHero(String name) {
        Random rnd = new Random();
        Hero hero =  new Hero(name, rnd.nextInt(100), rnd.nextInt(100), 100);
        System.out.println("Random hero named: " + hero.getName() + " generated (" +
                "atk = " + hero.getAtk() + "def = " + hero.getDef() + ")");
        return hero;
    }
}
