package model;

import model.exceptions.IdNotFoundException;
import model.exceptions.TitleNotUniqueException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents all projects with an arrayList.
 */
public class ProjectsManager {

    private int nextProjectId;
    private final ArrayList<Project> listOfProjects;

    /**
     * Constructor
     * sets nextProjectId to 1 by default.
     * @author Emilia Hannu
     */
    public ProjectsManager() {
        this.nextProjectId=1;
        listOfProjects = new ArrayList<>();
    }

    /**
     * Gets a copy of the project list
     * @return a copied arraylist of the projects
     */
    public ArrayList<Project> getListOfProjects() {
        ArrayList<Project> list = new ArrayList<>();
        for(int i=0;i<listOfProjects.size();i++) {
            list.add(i,listOfProjects.get(i));
        }
        return list;
    }

    /**
     * Clears the project list of all elements and adds all elements from the incoming project list.
     * @param incomingProjects is a list of projects sent to be added to project list
     */
    public void setProjects(List<Project> incomingProjects) {
        listOfProjects.clear();
        listOfProjects.addAll(incomingProjects);
        nextProjectId = getHighestId();
        nextProjectId++;

    }

    /**
     * Checks if a title already exists by comparing the title to all existing project titles
     * @param title is the name of the new project
     * @return true if title is unique, if not return true.
     */
    public boolean isTitleUnique(String title) {
        for(int i=0;i< listOfProjects.size();i++) {
            if(listOfProjects.get(i).getTitle().equals(title)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds the project to the list if the title is unique.
     * @param title is the projects name
     * @param descr describes the project purpose by a string
     * @return the new project
     */
    public Project addProject(String title, String descr) {
        if(!isTitleUnique(title))
            throw new TitleNotUniqueException("This title already exist...");
        Project newProject = new Project(title, descr, nextProjectId);
        listOfProjects.add(newProject);
        nextProjectId++;
        return newProject;
    }

    /**
     * Removes the desired project from the list.
     * @param project represents the project to be deleted.
     */
    public void removeProject(Project project) {
        listOfProjects.remove(project);
    }

    /**
     * Gets the project with its corresponding id
     * @param id the projects identifier number
     * @return the wanted project
     */
    public Project getProjectById(int id) {
        for(int i=0;i<listOfProjects.size();i++) {
            if(id==listOfProjects.get(i).getId()) {
                return listOfProjects.get(i);
            }
        }
        throw new IdNotFoundException("Could not find project with this id.");
    }

    /**
     * Finds a project by its title
     * @param titleStr is the name of the project
     * @return a list containing only the project
     */
    public ArrayList<Project> findProjects(String titleStr) {
        ArrayList<Project> list = new ArrayList<>();
        for(int i=0;i<listOfProjects.size();i++) {
            if(listOfProjects.get(i).getTitle().equals(titleStr)) {
                list.add(listOfProjects.get(i));
            }
        }
        return list;
    }

    private int getHighestId() {
        int highestID = listOfProjects.get(0).getId();
        for(int i=1;i<listOfProjects.size();i++) {
            if(listOfProjects.get(i).getId()>highestID)
                highestID=listOfProjects.get(i).getId();
        }
        return highestID;
    }

    /**
     * Prints all projects and the id for the next project to be made
     * @return the string containing all projects
     */
    @Override
    public String toString() {
        return "ALL PROJECTS: (ProjectsManager)\n" +
                "nextProjectId=" + nextProjectId +
                ", listOfProjects=" + listOfProjects +
                "\n";
    }
}
