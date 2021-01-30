package ticketbooth.service;


import ticketbooth.model.Ticket;

public interface TicketService {

    Ticket createTicket();
    boolean checkTicket(String ticketId);
    Ticket createStaffTicket(String staffId);
}
