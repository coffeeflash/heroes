package ticketbooth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ticketbooth.service.TicketService;
import ticketbooth.service.TicketServiceImpl;

@Configuration
public class ServiceConfiguration {

    @Bean
    public TicketService ticketService() {
        return new TicketServiceImpl();
    }

}
