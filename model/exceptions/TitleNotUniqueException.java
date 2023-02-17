package model.exceptions;
/**
 * Represents an exception which is thrown when title is already used.
 * @author Isak Wahlström
 */
public class TitleNotUniqueException extends RuntimeException{
    public TitleNotUniqueException(String msg) {
        super(msg);
    }
    public TitleNotUniqueException() {
        super();
    }
}
