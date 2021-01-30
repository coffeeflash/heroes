package ticketbooth.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ticketbooth.model.Ticket;

@RepositoryRestResource
public interface TicketRepository extends MongoRepository<Ticket, String> {}
