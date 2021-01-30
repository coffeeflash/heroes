package ticketbooth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticketbooth.model.Ticket;
import ticketbooth.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);


    @Override
    public Ticket createTicket() {
        return ticketRepository.save(new Ticket());
    }

    @Override
    public boolean checkTicket(String ticketId) {
        return ticketRepository.existsById(ticketId);
    }

    @Override
    public Ticket createStaffTicket(String staffId) {
        Ticket staffTicket = new Ticket();
        staffTicket.setId(staffId);
        return ticketRepository.save(staffTicket);
    }
}
