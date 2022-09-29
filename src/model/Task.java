
package model;
import model.Prio;
import model.TaskState;

import java.io.Serializable;
import java.time.LocalDate;


public class Task<T> implements Comparable<T>, Serializable {
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

    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", prio=" + prio +
                '}';
    }
    @Override
    public int compareTo(T o) {
        // compare....
        // Return 0 if equal!
        // else
        return 0;
    }
}
