package model;

/**
 * An enum which represents the state of a project, EMPTY, ONGOING and COMPLETED.
 * @author Isak Wahlström
 */
public enum ProjectState {
    EMPTY("Empty"), ONGOING("Ongoing"), COMPLETED("Completed");
    private final String str;

    /**
     * @param str gives the three states representation with strings.
     */
    private ProjectState(String str) {
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
