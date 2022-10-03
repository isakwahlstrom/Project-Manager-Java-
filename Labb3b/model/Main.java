package model;

public class Main {
    public static void main(String[] args) {
        Project project1 = new Project("Projekt Oktober22","Homework",1);
        //Task task = new Task("Do Homework", Prio.Low, 1);
        //Task task2 = new Task("Do Homework", Prio.High, 2);
        //task.setTakenBy("Karl");
        // System.out.println(task.toString());

        Project project2 = new Project("Projekt 2022","Vi bygger en mikroprocessor",2);
        //Task a = new Task("aaa", Prio.Medium, 1);

        //project2.addTask(a);
        //project2.addTask("aaa",Prio.Medium);
        project2.addTask("c",Prio.Low);
        project2.addTask("b",Prio.High);

        System.out.println("Removed : " + project2.removeTask(new Task<>("a", Prio.Medium, 1)));
        //System.out.println("Removed Task: " + project2.removeTask(a));
        //System.out.println(task.compareTo(task2));

        //System.out.println(project2.findTasks(new NotDoneMatcher()));
        System.out.println("Last updated: " + project2.getLastUpdated());

    }
}
