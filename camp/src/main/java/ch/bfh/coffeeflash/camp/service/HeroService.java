package ch.bfh.coffeeflash.camp.service;

import ch.bfh.coffeeflash.camp.model.Hero;

import java.util.List;

public interface HeroService {

    Hero createHero(String name);
    public List<Hero> getStrongHeroes();
}
