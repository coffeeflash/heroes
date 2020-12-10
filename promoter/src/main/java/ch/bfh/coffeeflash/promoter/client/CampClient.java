package ch.bfh.coffeeflash.promoter.client;

import ch.bfh.coffeeflash.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("camp")
public interface CampClient {

    @GetMapping("/createParty")
    EntityModel<Party> createParty(@RequestParam(value = "name") String name);
}
