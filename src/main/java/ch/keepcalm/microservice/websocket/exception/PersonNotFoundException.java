package ch.keepcalm.microservice.websocket.exception;

public class PersonNotFoundException extends BusinessException {

    public PersonNotFoundException() {
        super("Person not found.");
    }

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}