package ch.bfh.coffeeflash.camp.service;

import ch.bfh.coffeeflash.camp.model.Hero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService{

    private static final Logger LOG = LoggerFactory.getLogger(HeroServiceImpl.class);

    public Hero createHero(String name) {
        Random rnd = new Random();
        Hero hero =  new Hero(name, rnd.nextInt(100), rnd.nextInt(100), 100);
        LOG.info("Hero: " + hero.getName() + " generated (" +
                "atk = " + hero.getAtk() + ", def = " + hero.getDef() + ")");
        return hero;
    }
}
