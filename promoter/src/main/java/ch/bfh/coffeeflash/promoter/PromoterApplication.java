package ch.bfh.coffeeflash.promoter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PromoterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromoterApplication.class, args);
    }

}
