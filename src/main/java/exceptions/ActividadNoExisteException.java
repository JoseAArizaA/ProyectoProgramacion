package exceptions;

public class ActividadNoExisteException extends RuntimeException {
    public ActividadNoExisteException(String message) {
        super(message);
    }
}
