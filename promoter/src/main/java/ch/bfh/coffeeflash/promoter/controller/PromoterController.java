package ch.bfh.coffeeflash.promoter.controller;

import ch.bfh.coffeeflash.promoter.client.TicketboothClient;
import ch.bfh.coffeeflash.promoter.service.PromoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromoterController {

    @Autowired
    private PromoterService promoterService;

    @Autowired
    private TicketboothClient ticketboothClient;

    @GetMapping(value = "/promoteFight")
    public String promoteFight() {
        String result = promoterService.promoteFight();
        return "The Promoter is proud to proclaim the following result of today's battle: "+result;
    }

    @GetMapping(value = "/promotePaidFight")
    public String promotePaidFight(@RequestParam String ticketId) {
        if(ticketboothClient.checkTicket(ticketId)){
            String result = "The Promoter is proud to proclaim the following result of today's ----paid---- tournament\n";
            for (int i = 0; i < 3; i++) {
                result += "Fight " + i + ": " + promoterService.promoteFight()+ " \n";
            }
            return result;
        }else{
            return "Sorry, you have to buy a valid ticket at the ticket booth first";
        }
    }
}
