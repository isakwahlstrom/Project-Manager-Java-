package model;

import model.matcher.ITaskMatcher;
import model.matcher.NotDoneMatcher;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class representing a project by title, description, id, time created and a list of tasks.
 * @author Isak Wahlström
 */
public class Project implements Comparable<Project>, Serializable {
    private String title;
    private int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;
    private ArrayList<Task> listOfTasks;

    /**
     * Package private constructor
     * Sets nextTaskId to 1 by default.
     * @param title Project's name
     * @param descr Describes the project
     * @param id unique identifer number for the project
     */
    Project(String title, String descr, int id) {
        this.title = title;
        this.id = id;
        this.description = descr;
        this.created = LocalDate.now();
        listOfTasks = new ArrayList<Task>();
        nextTaskId = 1;
    }

    /**
     * Package private constructor without parameters, used to copy projects, and not referencing.
     */
    Project() {

    }
    public String getTitle() { return title; }
    public int getId() { return id; }

    public String getDescription() { return description; }

    public LocalDate getCreated() { return created; }

    public int getNextTaskId() { return nextTaskId; }

    /**
     * Access method which gets the task with the corresponding id
     * @param id the task with this identifier number to get
     * @return task with this id from the list.
     */
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

    /**
     * Access method, gets copy of the projects tasks
     * @return copy of the list of tasks
     */
    public ArrayList<Task> getListOfTasks() {
        ArrayList<Task> temp = new ArrayList<>();
        for(int i=0;i< listOfTasks.size();i++) {
            temp.add(new Task());
            temp.add(i,listOfTasks.get(i));
        }
        return temp;
    }

    /**
     * Method to get tasks using a matcher, if tasks is matched, adds it to a temporary list
     * @param matcher the matcher to find the tasks
     * @return the sorted temporary list which is sorted with the help of compareTo
     */
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

    /**
     * Creates a task, with the arguments descr and prio then adds the task to the list
     * @param descr Task description
     * @param prio Task priority
     * @return the task which was added to the list
     */
    public Task addTask(String descr, Prio prio) {
        Task task = new Task(descr,prio,nextTaskId);
        listOfTasks.add(task);
        nextTaskId++;
        return task;
    }

    /**
     * Removes the task which is equal to the task in the list
     * @param task the task to remove
     * @return the task removed
     */
    public Task removeTask(Task task){
        listOfTasks.remove(task);
        return task;
    }

    /**
     * Method to describe the state of a project, if project is empty, completed or ongoing
     * @return the project state
     */
    public ProjectState getProjectState() {
        if (listOfTasks.isEmpty())
            return ProjectState.EMPTY;

        if(findTasks(new NotDoneMatcher()).isEmpty())
            return ProjectState.COMPLETED;

        return ProjectState.ONGOING;
    }

    /**
     * Get the date when a task was last updated, or if empty, the date which project was created
     * @return the date
     */
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

    /**
     * Compares two tasks titles
     * @param other the compared object, downcast to project
     * @return true if titles are equal, else returns false
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof Project) {
            Project project = (Project) other;
            return (this.getTitle().equals(project.getTitle()));
        }
        return false;
    }

    /**
     * Compares two tasks titles
     * @param other the object to be compared
     * @return integer of the comparison, zero if titles are equal, else positive or negative value
     */
    @Override
    public int compareTo(Project other) {
        return this.title.compareTo(other.title);
    }

    /**
     * Used to print a projects data members and their values
     * @return the string with all the data members.
     */
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
