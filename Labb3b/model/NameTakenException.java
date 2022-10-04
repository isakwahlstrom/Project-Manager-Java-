package model.exceptions;

public class NameTakenException extends RuntimeException {
    public NameTakenException(String msg) {
        super(msg);
    }
    public NameTakenException() {
        super();
    }
}
