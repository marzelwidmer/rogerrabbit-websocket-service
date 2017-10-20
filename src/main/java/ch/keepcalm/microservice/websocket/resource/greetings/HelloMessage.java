package ch.keepcalm.microservice.websocket.resource.greetings;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class HelloMessage {

    private String name;


}