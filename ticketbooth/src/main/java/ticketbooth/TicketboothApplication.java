package ticketbooth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import ticketbooth.model.Ticket;
import ticketbooth.repository.TicketRepository;
import ticketbooth.service.TicketService;

@SpringBootApplication
@EnableEurekaClient
public class TicketboothApplication implements ApplicationRunner {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketboothApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// create some staff tickets...
		if (ticketRepository.count() == 0) {
			Ticket ticket1 = ticketService.createStaffTicket("VIP001");
			Ticket ticket2 = ticketService.createStaffTicket("VIP002");
			Ticket ticket3 = ticketService.createStaffTicket("VIP003");

			System.out.println(ticket1.getId());
			System.out.println(ticket2.getId());
			System.out.println(ticket3.getId());
		}
	}
}
