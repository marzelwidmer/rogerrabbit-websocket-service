package ch.keepcalm.microservice.websocket.resource.greetings;

import ch.keepcalm.microservice.websocket.domain.Person;
import ch.keepcalm.microservice.websocket.resource.person.PersonResourceAssembler;
import ch.keepcalm.microservice.websocket.resource.person.PersonService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    PersonService personService;
    PersonResourceAssembler personResourceAssembler;

    public GreetingController(PersonService personService, PersonResourceAssembler personResourceAssembler) {
        this.personService = personService;
        this.personResourceAssembler = personResourceAssembler;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }


    @MessageMapping("/person/hello")
    @SendTo("/topic/persons")
    public Person person(HelloMessage message) throws Exception {
        Person personToSave = Person.builder().firstName(message.getName()).lastName("Alvarez").build();
        personService.save(personToSave);

//        List<PersonResource> personResources = new ArrayList<>();
//
//        this.personService.getPersons().stream().forEach(
//                person ->  personResources.add(personResourceAssembler.toResource(person, person.getId()))
//
//        );
        return personToSave;
    }

}
