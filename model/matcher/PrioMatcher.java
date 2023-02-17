package model.matcher;

import model.Prio;
import model.Task;

/**
 * A matcher finding tasks based on priority implementing ITaskMatcher.
 * @author Isak Wahlström
 */
public class PrioMatcher implements ITaskMatcher {
    private final Prio prio;

    /**
     * Constructor which creates a PrioMatcher.
     * @param prio Prio to match the task with.
     */
    public PrioMatcher(Prio prio) {
        this.prio = prio;
    }

    /**
     * @param task the task which is argument for match
     * @return true if matchers prio is the same as task's prio, else returns false.
     */
    @Override
    public boolean match(Task task) {
        return prio.equals(task.getPrio());
    }
}
