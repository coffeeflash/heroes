package ch.bfh.coffeeflash.camp;

import ch.bfh.coffeeflash.camp.repository.HeroRepository;
import ch.bfh.coffeeflash.camp.service.HeroService;
import ch.bfh.coffeeflash.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CampApplication implements ApplicationRunner {

	@Autowired
	private PartyService partyService;

	@Autowired
	private HeroService heroService;

	@Autowired
	private HeroRepository heroRepository;

	public static void main(String[] args) {
		SpringApplication.run(CampApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (heroRepository.count() == 0) {
			heroService.createHero("Superman");
			heroService.createHero("Batman");
			heroService.createHero("Wonder Woman");
			heroService.createHero("Spiderman");
			heroService.createHero("Aquaman");
			heroService.createHero("Green Lantern");
			heroService.createHero("Flash");
			heroService.createHero("Batwoman");
			heroService.createHero("Flash");
			heroService.createHero("Godzilla");
			heroService.createHero("Antman");
		}
	}
}
