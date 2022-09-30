package model;

public class NotDoneMatcher implements ITaskMatcher {
    @Override
    public boolean match(Task task) {
        if(task.getState().equals(TaskState.TO_DO) || task.getState().equals(TaskState.IN_PROGRESS)) {
            return true;
        }
        return false;
    }
}
