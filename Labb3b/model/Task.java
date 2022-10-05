package model;

import model.exceptions.NameTakenException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a task by description, id, takenBy, state, lastUpdated and priority.
 *
 * @author Emilia Hannu
 */

public class Task implements Comparable<Task>, Serializable {
    private final String description;
    private int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private final Prio prio;

    /**
     * (Package private) Constructor
     * sets takenBy to null and state to 'TO DO' by default.
     * @param descr describes the task
     * @param prio is the tasks prioritization order
     * @param id is the tasks unique identifier number
     */
    Task(String descr, Prio prio, int id) {
        this.id = id;
        this.prio = prio;
        this.description = descr;
        this.lastUpdate = LocalDate.now();
        this.state = TaskState.TO_DO;
        this.takenBy = null;
    }

    /**
     * Package private constructor without parameters, used to copy tasks, and not referencing.
     */
    //Task(){

    //}

    public String getDescription() {return description;}

    public int getId() {return id;}

    public String getTakenBy() {return takenBy;}

    public TaskState getState() {return state;}

    public LocalDate getLastUpdate() {return lastUpdate;}

    public Prio getPrio() {return prio;}


    /**
     * Assigns the task to a name.
     * @param takenBy is a string containing the name.
     * @throws NameTakenException if the task is already taken.
     */
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

    /**
     * Prints the task with its description, id, priority and state.
     * If it's been assigned to someone it returns a string with that information too.
     *
     * @return a string with "Assign to" if the task has been assigned to someone.
     * If not, return a string without assigned-info.
     */
    @Override
    public String toString() {
        if(takenBy!=null) {
            return  "Task: " + description +
                    ", ID: " + id +
                    ", Priority: " + prio +
                    ", Assigned to: " + takenBy +
                    ", state: " + state + "\n";
        }
        return " Task: " + description  +
                ", ID: " + id +
                ", Priority: " + prio +
                ", State: " + state + "\n";
    }

    /**
     * Compares two tasks priorities and descriptions.
     * @param other is the compared object.
     * @return true if both tasks' prio and description is the same, else return false.
     */

    @Override
    public boolean equals(Object other) {
        if(other instanceof Task) {
            Task task = (Task) other;
            return (this.prio.equals(task.getPrio()) && this.description.equals(task.getDescription()));
        }
        return false;
    }

    /**
     * Compares two tasks priorities, if the priorities are equal, compares descriptions
     * @param other the object to be compared.
     * @return integer of the comparison. Zero if descriptions and priorities are equal, else negative or positive value.
     */
    @Override
    public int compareTo(Task other) {
        int result = 0;
        result = this.prio.toString().compareTo(other.prio.toString());
        if (result != 0) return result;
        else {
            return this.description.compareTo(other.description);
        }
    }
}
