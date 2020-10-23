package ch.bfh.coffeeflash.camp.config;

import ch.bfh.coffeeflash.camp.service.HeroService;
import ch.bfh.coffeeflash.camp.service.HeroServiceImpl;
import ch.bfh.coffeeflash.camp.service.PartyService;
import ch.bfh.coffeeflash.camp.service.PartyServiceImpl;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@Configuration
@EnableMongoRepositories(basePackages = "ch.bfh.coffeeflash.camp.repository")
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new HeroServiceImpl();
    }

    @Bean
    public PartyService partyService() {
        return new PartyServiceImpl();
    }

    @Bean
    @DependsOn("mongo")
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "heroes");
    }

    @Bean(destroyMethod="close")
    public Mongo mongo() throws IOException {
        return new EmbeddedMongoBuilder()
                .version("3.4.17")
                .bindIp("localhost")
                .port(27017)
                .build();
    }
}
