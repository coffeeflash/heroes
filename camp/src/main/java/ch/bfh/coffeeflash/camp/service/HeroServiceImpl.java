package ch.bfh.coffeeflash.camp.service;

import ch.bfh.coffeeflash.camp.model.Hero;
import ch.bfh.coffeeflash.camp.repository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService{

    @Autowired
    private HeroRepository heroRepository;

    private static final Logger LOG = LoggerFactory.getLogger(HeroServiceImpl.class);

    public Hero createHero(String name) {
        Random rnd = new Random();
        Hero hero =  new Hero();
        hero.setName(name);
        hero.setAtk(rnd.nextInt(100));
        hero.setDef(rnd.nextInt(100));
        hero.setHp(100);

        hero = heroRepository.save(hero); // overwrites hero without uuid with persisted hero with uuid

        LOG.info("Hero: " + hero.getName() + " generated (" +
                "atk = " + hero.getAtk() + ", def = " + hero.getDef() + ")\n" +
                "his UUID is: " + hero.getId());

        return hero;
    }

    public List<Hero> getStrongHeroes(){
        return heroRepository.findByAtkGreaterThan(50);
    }
}
