package model;

import model.matcher.ITaskMatcher;
import model.matcher.NotDoneMatcher;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
public class Project<T> implements Comparable<Project>, Serializable {
    private String title;
    private int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;
    private ArrayList<Task> listOfTasks;

    Project(String title, String descr, int id) {
        this.title = title;
        this.id = id;
        this.description = descr;
        this.created = LocalDate.now();
        listOfTasks = new ArrayList<Task>();
        nextTaskId = 1;
    }
    public String getTitle() { return title; }

    public int getId() { return id; }

    public String getDescription() { return description; }

    public LocalDate getCreated() { return created; }

    public int getNextTaskId() { return nextTaskId; }

    public Task getTaskById(int id) {
        int position = 0;
        for(int i=0;i< listOfTasks.size();i++) {
            if(id==listOfTasks.get(i).getId())
               position = i;
            else {
                throw new IllegalStateException("This task-ID does not exist");
            }
        }
        return listOfTasks.get(position);
    }

    public ArrayList<Task> getListOfTasks() {
        ArrayList<Task> temp = new ArrayList<>();
        for(int i=0;i< listOfTasks.size();i++) {
            temp.add(i,listOfTasks.get(i));
        }
        return temp;
    }

    public ArrayList<Task> findTasks(ITaskMatcher matcher) {
        ArrayList<Task> tmp = new ArrayList<>();
        for (int i=0;i<listOfTasks.size();i++) {
            if(matcher.match(listOfTasks.get(i))) {
                tmp.add(listOfTasks.get(i));
            }
        }
        Collections.sort(tmp);
        return tmp;
    }

    public Task addTask(String descr, Prio prio) {
        Task task = new Task(descr,prio,nextTaskId);
        listOfTasks.add(task);
        nextTaskId++;
        return task;
    }

    public Task removeTask(Task task){
        listOfTasks.remove(task);
        return task;
    }

    public ProjectState getProjectState() {     //getState()
        if (listOfTasks.isEmpty())
            return ProjectState.EMPTY;

        if(findTasks(new NotDoneMatcher()).isEmpty())
            return ProjectState.COMPLETED;

        return ProjectState.ONGOING;
    }

    public LocalDate getLastUpdated() {
        Task tmp;
        if(listOfTasks.isEmpty()) {
            return created;
        }
        tmp = listOfTasks.get(0);
        for(int i=1;i< listOfTasks.size();i++) {
            if(tmp.getLastUpdate().getYear()==(listOfTasks.get(i).getLastUpdate()).getYear()) {
                if(tmp.getLastUpdate().getDayOfYear()<listOfTasks.get(i).getLastUpdate().getDayOfYear()) {
                    tmp = listOfTasks.get(i);
                }
            } else {
                if(tmp.getLastUpdate().getYear()<(listOfTasks.get(i).getLastUpdate()).getYear()) {
                    tmp = listOfTasks.get(i);
                }
            }
        }
        return tmp.getLastUpdate();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Project) {
            Project project = (Project) obj;
            return (this.getTitle().equals(project.getTitle()));
        }
        return false;
    }

    @Override
    public int compareTo(Project other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Project: " +  title +
                ", id: " + id +
                ", description: " + description  +
                ", created: " + created +
                ", (nextTaskId: " + nextTaskId +
                ")\n";
    }
}
