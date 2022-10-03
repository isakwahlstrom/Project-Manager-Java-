package model.matcher;

import model.Task;
import model.matcher.ITaskMatcher;

public class TakenByMatcher implements ITaskMatcher {
    private String takenby;

    public TakenByMatcher(String takenby) {
        this.takenby = takenby;
    }

    @Override
    public boolean match(Task task) {
        return takenby.equals(task.getTakenBy());
    }
}
