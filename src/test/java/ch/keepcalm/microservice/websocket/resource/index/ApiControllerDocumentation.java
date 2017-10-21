package ch.keepcalm.microservice.websocket.resource.index;

import ch.keepcalm.microservice.websocket.resource.person.PersonRepository;
import ch.keepcalm.microservice.websocket.resource.person.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
@AutoConfigureRestDocs(value = "target/generated-snippets"
//        ,uriScheme = "https",
//        uriHost = "keepcalm.ch",
//        uriPort = 443
)
public class ApiControllerDocumentation {

    private static final String SELF = "self";
    private static final String SELF_DESCRIPTION = "This resource";

    private static final String PERSONS = "persons";
    private static final String PERSONS_DESCRIPTION = "The resource perons";

    private static final String UI_GREETINGS_WEBSOCKETS = "ui-greetings-websocket";
    private static final String UI_GREETINGS_WEBSOCKETS_DESCRIPTION = "Greetings Websocket";

    private static final String UI_PERSON = "ui-person";
    private static final String UI_PERSON_DESCRIPTION = "Person Web";

    private static final String DOCUMENTATION = "documentation";
    private static final String DOCUMENTATION_DESCRIPTION = "Documentation link";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository ersonRepository;

    @MockBean
    private PersonService personService;

    @Test
    public void getApi() throws Exception {
        mockMvc.perform(get("/").accept(MediaTypes.HAL_JSON))
                .andExpect(status().isOk())
                .andDo(document("{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        links(halLinks(),
                                linkWithRel(SELF).description(SELF_DESCRIPTION),
                                linkWithRel(UI_GREETINGS_WEBSOCKETS).description(UI_GREETINGS_WEBSOCKETS_DESCRIPTION),
                                linkWithRel(UI_PERSON).description(UI_PERSON_DESCRIPTION),
                                linkWithRel(PERSONS).description(PERSONS_DESCRIPTION),
                                linkWithRel(DOCUMENTATION).description(DOCUMENTATION_DESCRIPTION)

                        )));
    }
}
