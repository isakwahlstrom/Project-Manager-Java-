
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

    }

    public void setTakenBy(String takenBy) {
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
        return "Task{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", prio=" + prio +
                '}';
    }
    @Override
    public int compareTo(Task o) {
        if(this.prio.equals(o.prio)) {
            System.out.println("Prio equal!");
        } else {
            if(this.description.equals(o.description)) {
                System.out.println("Description equal!");
            }
        }
        //Compare
        // Return 0 if equal!
        // else
        return 0;
    }
}
