package model.exceptions;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException() {
        super();
    }

    public IdNotFoundException(String s) {
        super(s);
    }
}
