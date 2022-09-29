package model;

public class NotDoneMatcher implements ITaskMatcher {
    @Override
    public boolean match(Task task) {
        return TaskState.IN_PROGRESS.equals(task.getState());
    }
}
