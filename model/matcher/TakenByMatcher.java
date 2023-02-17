package model.matcher;

import model.Task;
/**
 * A matcher finding tasks based on which person the task is assigned to implementing ITaskMatcher.
 * @author Isak Wahlström
 */

public class TakenByMatcher implements ITaskMatcher {
    private final String takenby;

    /**
     * Constructor which creates a matcher
     * @param takenby name to match the task with.
     */
    public TakenByMatcher(String takenby) {
        this.takenby = takenby;
    }

    /**
     * @param task the task which is argument for match
     * @return true if matchers takenby is the same as task's takenby.
     */
    @Override
    public boolean match(Task task) {
        return takenby.equals(task.getTakenBy());
    }
}
