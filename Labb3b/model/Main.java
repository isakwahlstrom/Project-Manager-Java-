package model;

public class Main {
    public static void main(String[] args) {
        Task task = new Task<>("Do homework",Prio.High, 1234);
        System.out.println(task.toString());
    }
}
