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
    public LocalDate getLastUpdated() {
       Task tmp;
        if(listOfTasks.isEmpty()) {
            return created;
        }
        tmp = listOfTasks.get(0);
        //tmp.getLastUpdate().withMonth(11);
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
        // Sortera!!!!!!!!!!!!! HUR????

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
    //@Override

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public int compareTo(Project o) {
        if(this.equals(o));
        return 1;


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
