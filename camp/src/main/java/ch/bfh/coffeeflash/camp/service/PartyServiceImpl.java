package ch.bfh.coffeeflash.camp.service;

import ch.bfh.coffeeflash.camp.model.Hero;
import ch.bfh.coffeeflash.camp.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyServiceImpl implements PartyService{

    @Autowired
    HeroService heroService;

    private static final Logger LOG = LoggerFactory.getLogger(PartyServiceImpl.class);

    public Party createParty(String name) {

        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroes.add(heroService.createHero("Hero" + i));
        }
        Party party = new Party(name, heroes);
        LOG.info("Party " + name + " has been created");
        LOG.info("There are " + heroService.getStrongHeroes().size() + " strong heroes (atk > 50)");
        return party;
    }
}
