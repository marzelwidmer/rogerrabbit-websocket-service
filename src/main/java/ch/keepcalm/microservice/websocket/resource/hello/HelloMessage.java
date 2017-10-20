package ch.keepcalm.microservice.websocket.resource.hello;

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