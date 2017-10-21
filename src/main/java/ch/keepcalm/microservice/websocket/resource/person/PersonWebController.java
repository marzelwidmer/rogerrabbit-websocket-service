package ch.keepcalm.microservice.websocket.resource.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonWebController {

    PersonService personService;

    public PersonWebController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView("person");
        mav.addObject("persons", this.personService.getPersons());
        return mav;
    }
}
