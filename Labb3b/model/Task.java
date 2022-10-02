
package model;
import model.Prio;
import model.TaskState;

import java.io.Serializable;
import java.time.LocalDate;


public class Task<T> implements Comparable<Task>, Serializable {
    private String description;
    private int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;


    public Task(String descr, Prio prio, int id) {
        this.id = id;
        this.prio = prio;
        this.description = descr;
        lastUpdate = LocalDate.now();
        state = TaskState.TO_DO;
        takenBy = null;
    }
    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public TaskState getState() {
        return state;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public Prio getPrio() {
        return prio;
    }

    public void setTakenBy(String takenBy) {
        if(this.takenBy!=null) {
            throw new IllegalStateException("Task already taken");
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
            return "Task: " +
                    "description:" + description +
                    ", ID:" + id +
                    ", Priority:" + prio
                    + ", Assigned to:" + takenBy + ", state:" + state + "\n";
        }
        return "Task: " +
            "Description:" + description  +
                    ", ID:" + id +
                    ", Priority:" + prio +
                    ", State:" + state + "\n";

    }
    
    //Skriva om equals????
    
    @Override
    public int compareTo(Task o) {
        if(this.prio.compareTo(o.prio)<0) {
            return -1;
        } else {
            if (this.prio.compareTo(o.prio) > 0) {
                return 1;
            }
        }
            if(this.description.compareTo(o.description)<0) {
                return -1;
            } else {
                if(this.description.compareTo(o.description)>0) {
                    return 1;
                }
            }
            return 0;
    }

}
