package model.exceptions;

/**
 * Represents an exception which is thrown when task is already assigned to a person.
 * @author Isak Wahlström
 */
public class NameTakenException extends RuntimeException {
    /**
     * @param msg string sent to superclass RuntimeException.
     */
    public NameTakenException(String msg) {
        super(msg);
    }

    /**
     * Calls for superclass RuntimeException.
     */
    public NameTakenException() {
        super();
    }
}
