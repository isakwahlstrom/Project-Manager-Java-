package ui;

//import model.matcher.AllTasksmatcher;
import model.exceptions.NameTakenException;
import model.matcher.ITaskMatcher;
import model.matcher.NotDoneMatcher;
import model.matcher.PrioMatcher;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 //* User interactions for a specific project, current project.
 //* The user selects actions on current project in the projectLoop method.

class CurrentProjectUI {
    private Project currentProject;
    private final Scanner scan;
    // package private visibility - only visible to other classes in
    // package ui - intended for MainUI.
    CurrentProjectUI(Scanner scan) {
        this.scan = scan;
        this.currentProject = null; // TODO: Ugly!
    }

    void setCurrentProject(Project project) {
        this.currentProject = project;
        projectLoop();
    }

    Project getCurrentProject() {
        return currentProject;
    }

    void projectLoop() {
        char choice;
        do {
            printCurrentProjectMenu();
            choice = InputUtils.scanAndReturnFirstChar(scan);

            switch (choice) {
                case 'T':
                    printTasks(currentProject.getListOfTasks());
                    break;
                case 'N':
                    viewTasks(new NotDoneMatcher());
                    break;
                case 'H':
                    viewTasks(new PrioMatcher(Prio.High));
                    break;
                case 'A':
                    addTask();
                    break;
                case 'U':
                    updateTask();
                    break;
                case 'X':
                    break;
                case 'R':
                    removeTask();
                    break;
                case 'S':
                    getProjectState();
                    break;
                case 'L':
                    lastUpdated(); break;
                default:
                    System.out.println("Unknown command");
            }

        } while (choice != 'X');
    }

    private void viewTasks(ITaskMatcher matcher) {
        System.out.println(currentProject.toString());
        ArrayList<Task> tasks = currentProject.findTasks(matcher);
        printTasks(tasks);
    }

    private void addTask() {
        System.out.print("Description? ");
        String descr = scan.nextLine();
        System.out.print("Priority (L)ow, (M)edium, (H)igh? ");
        char prioChar = InputUtils.scanAndReturnFirstChar(scan);
        Prio prio = prioChar == 'H' ? Prio.High : prioChar == 'L' ? Prio.Low : Prio.Medium;
        currentProject.addTask(descr, prio);
    }

    private void updateTask() {
        System.out.print("Task id? ");
        int id = scan.nextInt();
        id--;
        scan.nextLine(); //remove "new line" from scanner buffer
        Task task = currentProject.getTaskById(id);
        if (task != null) {
            System.out.println(task);
            System.out.print("New state (I)n progress (D)one? ");
            char stateChar = InputUtils.scanAndReturnFirstChar(scan);
            if (stateChar == 'I') {
               try {
                    System.out.print("Taken by (name) ");
                    String person = scan.nextLine();
                    task.setState(TaskState.IN_PROGRESS);
                    task.setTakenBy(person);
                } catch(NameTakenException e){
                   System.out.println("Task already assigned to " + task.getTakenBy());
                }
            } else if (stateChar == ('D')) {
                task.setState(TaskState.DONE);
            }
        } else {
            System.out.println("Id not found.");
        }
    }

    private void printCurrentProjectMenu() {
        System.out.println("--- Manage " + currentProject.getTitle() + " ---");
        System.out.println("T - list all tasks");
        System.out.println("N - list tasks not done");
        System.out.println("H - list high priority tasks");
        System.out.println("A - add task");
        System.out.println("U - update task");
        System.out.println("R - remove task");
        System.out.println("S - Get project state");
        System.out.println("L - Get last updated task");
        System.out.println("X - exit project menu");
        System.out.println("----------");
    }

    private void printTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added");
        } else {
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }
    }
    private void removeTask() {
        if(!currentProject.getListOfTasks().isEmpty()) {
            System.out.print("Task id? ");
            int id = scan.nextInt();
            id--;
            scan.nextLine(); //remove "new line" from scanner buffer
            Task task = currentProject.getTaskById(id);
            currentProject.removeTask(task);
            System.out.println("Task removed: " + task.toString());
        } else {
            System.out.println("Current project is empty, can not delete task");
        }
    }
    private void getProjectState() {
        System.out.println("Project is: " + currentProject.getProjectState());
    }
    private void lastUpdated() {
        if(!currentProject.getListOfTasks().isEmpty())
        System.out.println("Last updated task was: " + currentProject.getLastUpdated());
       else
           System.out.println("Project was created: " + currentProject.getLastUpdated());
    }
}
