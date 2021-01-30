package ticketbooth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ticketbooth.model.Ticket;
import ticketbooth.service.TicketService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping(value = "/buyTicket")
    public Ticket buyTicket() {
        return ticketService.createTicket();
    }

    @GetMapping(value = "/checkTicket")
    public boolean checkTicket(@RequestParam String ticketId) {
        return ticketService.checkTicket(ticketId);
    }
}
