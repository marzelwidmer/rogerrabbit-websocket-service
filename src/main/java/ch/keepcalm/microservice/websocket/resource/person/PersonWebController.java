package ch.keepcalm.microservice.websocket.resource.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonWebController {

    PersonService personService;
    PersonResourceAssembler personResourceAssembler;

    public PersonWebController(PersonService personService, PersonResourceAssembler personResourceAssembler) {
        this.personService = personService;
        this.personResourceAssembler = personResourceAssembler;
    }

    @GetMapping("/person")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView("person");
        mav.addObject("persons", this.personService.getPersons());
        return mav;
    }
}
