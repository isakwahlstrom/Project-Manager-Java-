package model;
/**
 * An enum which represents the different states of a task, To Do, IN PROGRESS and DONE.
 * @author Isak Wahlström
 */
public enum TaskState {
    TO_DO("To do"), IN_PROGRESS("In progress"), DONE("Done");

    private final String str;
    /**
     * @param str gives the three states representation with strings.
     */
    private TaskState(String str) {
        this.str = str;
    }
    /**
     * returns a string with the corresponding state.
     */
    @Override
    public String toString() {
        return str;
    }
}
