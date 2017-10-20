package ch.keepcalm.microservice.websocket.resource.person;

import ch.keepcalm.microservice.websocket.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author marcelwidmer
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findById(String id);


}
