package model;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Do Homework",Prio.Low, 1);
        Task task2 = new Task("Do Homework",Prio.High, 2);
        //task.setTakenBy("Karl");
        //System.out.println(task.toString());
       Project project = new Project("Projekt 2022","Vi bygger en mikroprocessor",1);
        project.addTask("tada",Prio.Low);
        project.addTask("tada",Prio.High);
        project.addTask("tada",Prio.Medium);
        //System.out.println(task.compareTo(task2));

       System.out.println(project.findTasks(new NotDoneMatcher()));
        System.out.println(project.getLastUpdated());



    }
}
