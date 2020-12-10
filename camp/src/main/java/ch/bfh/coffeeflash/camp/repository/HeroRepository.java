package ch.bfh.coffeeflash.camp.repository;

import ch.bfh.coffeeflash.camp.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HeroRepository extends MongoRepository<Hero, String> {
//public interface HeroRepository extends CrudRepository<Hero, String> {
    List<Hero> findByAtkGreaterThan(int atk);
}
