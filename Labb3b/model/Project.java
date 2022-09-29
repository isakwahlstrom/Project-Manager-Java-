package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        listOfTasks = new ArrayList<Task>();
        nextTaskId = 1;
    }
    public Task addTask(String descr, Prio prio) {
        Task task = new Task(descr,prio,nextTaskId);
        listOfTasks.add(task);
        nextTaskId++;
        return task;
    }
    public ProjectState getProjectState() {
        int nrofdone = 0;
        if (listOfTasks.isEmpty()) {
            return ProjectState.EMPTY;
        }
        return ProjectState.ONGOING;
    }

    @Override
    public int compareTo(Project o) {
        return 0;
    }
}
