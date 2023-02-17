package model.matcher;
import model.Task;
import model.TaskState;

/**
 * A matcher finding tasks based on TaskState implementing ITaskMatcher.
 * @author Isak Wahlström
 */
public class NotDoneMatcher implements ITaskMatcher {
    /**
     * @param task the task which is argument for match
     * @return true if task is in progress or to do, else returns false
     */
    @Override
    public boolean match(Task task) {
        if(task.getState().equals(TaskState.TO_DO) || task.getState().equals(TaskState.IN_PROGRESS)) {
            return true;
        }
        return false;
    }
}
