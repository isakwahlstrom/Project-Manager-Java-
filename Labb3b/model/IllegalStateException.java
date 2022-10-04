package model.exceptions;

public class IllegalStateException extends RuntimeException {
    public IllegalStateException(String msg) {
        super(msg);
    }
    public IllegalStateException() {
        super();
    }
}
