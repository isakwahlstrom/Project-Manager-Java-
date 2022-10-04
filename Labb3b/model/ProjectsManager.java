package model;
import model.exceptions.TitleNotUniqueException;
import model.exceptions.TitleNotUniqueException;

import java.util.ArrayList;

public class ProjectsManager {

    private int nextProjectId;
    private ArrayList<Project> listOfProjects;

    public ProjectsManager() {
        this.nextProjectId = 1;
        listOfProjects = new ArrayList<>();
    }

    public ArrayList<Project> getListOfProjects() {
        ArrayList<Project> list = new ArrayList<>();
        for(int i=0;i< listOfProjects.size();i++) {
            list.add(i,listOfProjects.get(i));
        }
        return list;
    }

    public void setProject(ArrayList<Project> incomingProjects) {
        listOfProjects.clear();
        listOfProjects.addAll(incomingProjects);
    }

    public boolean isTitleUnique(String title) {
        for(int i=0;i< listOfProjects.size();i++) {
            if(listOfProjects.get(i).getTitle().equals(title)) {
                return false;
            }
        }
        return true;
    }

    public Project addProject(String title, String descr) {
        if(!isTitleUnique(title))
            throw new TitleNotUniqueException("This title already exist...");
        Project newProject = new Project(title, descr, nextProjectId);
        listOfProjects.add(newProject);
        nextProjectId++;
        return newProject;
    }

    public void removeProject(Project project) {
        listOfProjects.remove(project);
    }

    public Project getProjectById(int id) {
        if (id > listOfProjects.size())
            throw new IllegalStateException("This project-ID does not exist");     // behövs denna ens?
        return listOfProjects.get(id);
    }

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
        return listOfProjects.size();
    }

    @Override
    public String toString() {
        return "ALL PROJECTS: (ProjectsManager) { \n" +
                "nextProjectId=" + nextProjectId +
                ", listOfProjects=" + listOfProjects +
                "} \n";
    }
}
