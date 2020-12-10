package ch.bfh.coffeeflash.camp.service;

import ch.bfh.coffeeflash.camp.model.Hero;
import ch.bfh.coffeeflash.camp.model.Party;
import ch.bfh.coffeeflash.camp.repository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PartyServiceImpl implements PartyService{

    @Autowired
    HeroService heroService;

    @Autowired
    private HeroRepository heroRepository;

    private static final Logger LOG = LoggerFactory.getLogger(PartyServiceImpl.class);

    public Party createParty(String name) {
        System.out.println("Creating party with name "+name+"...");
        Party party = new Party();
        party.setName(name);
        List<Hero> allHeroes = (List<Hero>) heroRepository.findAll();
        Collections.shuffle(allHeroes);
        List<Hero> randomHeroes = new ArrayList<>(allHeroes.subList(0,4));

        party.setMembers(randomHeroes);
        LOG.info("Party " + name + " has been created");
        LOG.info("There are " + heroService.getStrongHeroes().size() + " strong heroes (atk > 50)");
        return party;
    }
}
