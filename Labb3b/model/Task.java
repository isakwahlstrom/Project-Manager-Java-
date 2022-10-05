package model;

import model.exceptions.NameTakenException;
import java.io.Serializable;
import java.time.LocalDate;


public class Task<T> implements Comparable<Task>, Serializable {
    private String description;
    private int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;

     Task(String descr, Prio prio, int id) {
        this.id = id;
        this.prio = prio;
        this.description = descr;
        lastUpdate = LocalDate.now();
        state = TaskState.TO_DO;
        takenBy = null;
    }
    
    public String getDescription() {return description;}

    public int getId() {return id;}

    public String getTakenBy() {return takenBy;}

    public TaskState getState() {return state;}

    public LocalDate getLastUpdate() {return lastUpdate;}

    public Prio getPrio() {return prio;}

    public void setTakenBy(String takenBy) {
        if(this.takenBy!=null) {
            throw new NameTakenException("Task already assigned to " + takenBy);
        }
        lastUpdate = LocalDate.now();
        this.takenBy = takenBy;
    }

    public void setState(TaskState state) {
        lastUpdate = LocalDate.now();
        this.state = state;
    }

    public void setId(int id) {
        lastUpdate = LocalDate.now();
        this.id = id;
    }
    @Override
    public String toString() {
        if(takenBy!=null) {
            return  "Task: " + description +
                    ", ID: " + id +
                    ", Priority: " + prio
                    + ", Assigned to: " + takenBy + ", state: " + state + "\n";
        }
        return " Task: " + description  +
                ", ID: " + id +
                ", Priority: " + prio +
                ", State: " + state + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Task) {
            Task task = (Task) obj;
            return (this.prio.equals(task.getPrio()) && this.description.equals(task.getDescription()));
        }
        return false;
    }

    @Override
    public int compareTo(Task other) {
        int result = 0;
        result = this.prio.compareTo(other.prio);
        if (result != 0) return result;
        else {
            return (result = this.description.compareTo(other.description));
        }
    }
}
