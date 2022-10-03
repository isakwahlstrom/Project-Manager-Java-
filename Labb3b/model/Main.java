package model;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Project project1 = new Project("Projekt Oktober22","Homework",1);
        //Task task = new Task("Do Homework", Prio.Low, 1);
        //Task task2 = new Task("Do Homework", Prio.High, 2);
        //task.setTakenBy("Karl");
        // System.out.println(task.toString());


        //Project project2 = new Project("Projekt 2022","Vi bygger en mikroprocessor",2);

        ArrayList<Project> listof2projects = new ArrayList<>(2);
        listof2projects.add(0, new Project("project1", "a", 1));
        listof2projects.add(1, new Project("project2", "b", 2));

        ProjectsManager testProject = new ProjectsManager();
        testProject.addProject("Autumn", "Work to do before christmas");

        System.out.println(testProject.getListOfProjects());
        System.out.println(listof2projects);

        testProject.setProject(listof2projects);
        System.out.println(testProject.getListOfProjects());


        //testProject.removeProject(testProject.getProjectById(0));
        //System.out.println(testProject.getListOfProjects());

        //Task a = new Task("aaa", Prio.Medium, 1);


        //project2.addTask(a);
        //project2.addTask("aaa",Prio.Medium);
        //project2.addTask("c",Prio.Low);
        //project2.addTask("b",Prio.High);

        //System.out.println("Removed : " + project2.removeTask(new Task<>("a", Prio.Medium, 1)));
        //System.out.println("Removed Task: " + project2.removeTask(a));
        //System.out.println(task.compareTo(task2));

        //System.out.println(project2.findTasks(new NotDoneMatcher()));
        //System.out.println("Last updated: " + project2.getLastUpdated());

    }
}
