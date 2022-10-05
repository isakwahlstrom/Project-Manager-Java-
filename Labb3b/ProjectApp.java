import io.ProjectsFileIO;
import model.Project;
import model.ProjectsManager;
import ui.MainUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class ProjectApp {

    private static final String FILE_NAME = "project.txt";

    public void run() throws Exception { // we do not catch all exceptions
        File projectsFile = new File(FILE_NAME);
        ProjectsManager projectsManager = new ProjectsManager();
        boolean couldReadFile = false;

        try {
            if (projectsFile.exists()) {
                List<Project> projects =  ProjectsFileIO.deSerializeFromFile(projectsFile);
                projectsManager.setProjects(projects);
                couldReadFile = true;
            } else {
                System.out.println("Could not load projects from the file, starting with an empty project list");
            }

            MainUI ui = new MainUI(projectsManager);
            ui.mainLoop();

        } catch (FileNotFoundException | ClassNotFoundException e) {
            System.out.println("Could not load projects from file, please check the data file.");
            System.out.println("Continuing with empty manager.");
        }

        // run method about to exit - save data
        if(couldReadFile || !projectsFile.exists()) {
            ArrayList<Project> projectsToSave = projectsManager.getListOfProjects();
            ProjectsFileIO.serializeToFile(projectsFile, projectsToSave);

        }
        System.out.println("Application exits");

    }

    public static void main(String[] args) throws Exception {

        ProjectApp app = new ProjectApp();
        app.run();
    }
}


