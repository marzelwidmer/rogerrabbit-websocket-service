package ch.keepcalm.microservice.websocket;

import ch.keepcalm.microservice.websocket.domain.Person;
import ch.keepcalm.microservice.websocket.resource.person.PersonRepository;
import ch.keepcalm.microservice.websocket.resource.person.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by marcelwidmer on 04/07/16.
 */
@SpringBootApplication
public class RogerRabbitService {

    PersonService personService;

    public RogerRabbitService(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RogerRabbitService.class, args);
    }



    @Bean
    CommandLineRunner init(PersonRepository personRepository) {
        return (args) -> {
            personService.save(Person.builder().firstName("Jone").lastName("Doe").build());
            personService.save(Person.builder().firstName("Jane").lastName("Doe").build());
            personService.save(Person.builder().firstName("Jessica").lastName("Rabbit").build());
            personService.save(Person.builder().firstName("Roger").lastName("Rabbit").build());
        };
    }

}