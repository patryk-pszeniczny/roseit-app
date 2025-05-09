package pl.roseitconsulting.roseitapp;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.roseitconsulting.roseitapp.model.Customer;
import pl.roseitconsulting.roseitapp.repository.CustomerRepository;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class RoseitAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoseitAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            System.out.println("Hello world!!!");
            Faker faker = new Faker();
            Random random = ThreadLocalRandom.current();
            Customer customer = new Customer(
                    faker.name().firstName(),
                    faker.internet().emailAddress(),
                    random.nextInt(16, 80)
            );
            customerRepository.save(customer);
        };
    }
}
