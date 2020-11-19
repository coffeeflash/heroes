package ch.bfh.coffeeflash.camp.controller;

import ch.bfh.coffeeflash.camp.model.Hero;
import ch.bfh.coffeeflash.camp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public @ResponseBody Iterable<Hero> list() {
        Iterable<Hero> allHeroes = heroRepository.findAll();

        for (Hero hero : allHeroes) {
            String heroId = hero.getId();
            Link selfLink = linkTo(HeroController.class).slash(heroId).withSelfRel();
            hero.add(selfLink);
        }

        Link link = linkTo(HeroController.class).withSelfRel();

        return CollectionModel.of(allHeroes, link);
    }

    @GetMapping("/{id}")
    public @ResponseBody Hero getById(@PathVariable String id) {
        Optional<Hero> optHero = heroRepository.findById(id);

        if (optHero.isPresent()) {
            Hero hero = optHero.get();

            hero.add(linkTo(HeroController.class).slash(hero.getId()).withSelfRel());

            return hero;
        }

        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Hero hero) { heroRepository.save(hero); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) { heroRepository.deleteById(id); }

}
