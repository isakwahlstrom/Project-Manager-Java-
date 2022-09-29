package model;

import java.io.Serializable;
import java.lang.reflect.Array;
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
    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public int getNextTaskId() {
        return nextTaskId;
    }
    /*public LocalDate getLastUpdated() {

    }*/
    public ArrayList<Task> getListOfTasks() {
        ArrayList<Task> temp = new ArrayList<>();
        for(int i=0;i< listOfTasks.size();i++) {
            temp.add(i,listOfTasks.get(i));
        }
        return temp;
    }
    public ArrayList<Task> findTasks(ITaskMatcher matcher) {
        ArrayList<Task> tmp = new ArrayList<>();
        for (int i=0;i< listOfTasks.size();i++) {
            if(matcher.match(listOfTasks.get(i))) {
                tmp.add(i,listOfTasks.get(i));
            }
        }
     return tmp;
    }
    public Task addTask(String descr, Prio prio) {
        Task task = new Task(descr,prio,nextTaskId);
        task.setState(TaskState.IN_PROGRESS);
        listOfTasks.add(task);
        nextTaskId++;
        return task;
    }
    public ProjectState getProjectState() {
        int nrofdone = 0;
        if (listOfTasks.isEmpty()) {
            return ProjectState.EMPTY;
        }
        if(findTasks(new NotDoneMatcher()).isEmpty()) {
            return ProjectState.COMPLETED;
        }
        return ProjectState.ONGOING;
    }

    @Override
    public int compareTo(Project o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", nextTaskId=" + nextTaskId +
                '}';
    }
}
