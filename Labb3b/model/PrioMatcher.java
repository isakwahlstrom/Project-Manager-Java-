package model;

public class PrioMatcher implements ITaskMatcher {
    private Prio prio;
    public PrioMatcher(Prio prio) {
        this.prio = prio;
    }
    @Override
    public boolean match(Task task) {
        return prio.equals(task.getPrio());
    }
}
