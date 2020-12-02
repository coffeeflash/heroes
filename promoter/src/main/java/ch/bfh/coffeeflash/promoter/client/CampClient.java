package ch.bfh.coffeeflash.promoter.client;

import ch.bfh.coffeeflash.promoter.model.Party;
import org.springframework.hateoas.EntityModel;

public interface CampClient {
    EntityModel<Party> createParty(String name);
}
