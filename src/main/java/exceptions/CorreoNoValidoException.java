package exceptions;

public class CorreoNoValidoException extends Exception {
    public CorreoNoValidoException(String msn) {
        super(msn);
    }
}
