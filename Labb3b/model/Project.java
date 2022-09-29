package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Project implements Comparable<Project>, Serializable {
    private String title;
    private int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;
    private ArrayList<Task> listOfTasks;

    public Project(String title, String descr, int id) {
        this.title = title;
        this.id = id;
        this.description = descr;
        this.created = LocalDate.now();
        listOfTasks = new ArrayList<>();
        nextTaskId = 1;
    }
    public Task addTask(String descr, Prio prio) {
        Task task = new Task(descr,prio,nextTaskId);
        listOfTasks.add(task);
        nextTaskId++;
        return task;
    }

    
    @Override
    public int compareTo(Project o) {
        return 0;
    }
}
