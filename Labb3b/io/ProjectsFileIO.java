package io;

import model.Project;
import java.io.*;
import java.util.List;


 /** Hints on how to implement serialization and deserialization
 * of lists of projects and users.
*/
public class ProjectsFileIO {

    /*
     * Call this method before the application exits, to store the users and projects,
     * in serialized form.
*/
    public static void serializeToFile(File file, List<Project> data) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(data);
        } finally {
            if(out!=null) {
                out.close();
            }
        }
    }

    /*
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
*/
   // @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            List<Project> projects = (List<Project>) in.readObject();
            return projects;
        } finally {
            if(in!=null) {
                in.close();
            }
        }
    }

    private ProjectsFileIO() {}
}

