package ch.bfh.coffeeflash.camp;

import ch.bfh.coffeeflash.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampApplication implements ApplicationRunner {

	@Autowired
	private PartyService partyService;

	public static void main(String[] args) {
		SpringApplication.run(CampApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		partyService.createParty("Heroes Party 1");
	}
}
