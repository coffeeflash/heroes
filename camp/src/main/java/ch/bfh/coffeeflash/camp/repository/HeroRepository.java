package ch.bfh.coffeeflash.camp.repository;

import ch.bfh.coffeeflash.camp.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends MongoRepository<Hero, String> {
}
