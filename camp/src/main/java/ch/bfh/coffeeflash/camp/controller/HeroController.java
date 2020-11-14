package ch.bfh.coffeeflash.camp.controller;

import ch.bfh.coffeeflash.camp.model.Hero;
import ch.bfh.coffeeflash.camp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public @ResponseBody Iterable<Hero> list(){
        return heroRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Hero> getById(@PathVariable String id) {
        return heroRepository.findById(id);
    }



}
