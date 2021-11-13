package main.duke.task;

import main.duke.DukeException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A <code>Storage</code> deals with loading tasks from the file and saving tasks in the file.
 */
public class Storage {

    public static File createNewFile() throws DukeException {
        File newFile = new File("data\\Storage.txt");
        boolean result;
        try {
            result = newFile.createNewFile();
            if (result){
                System.out.println("New Storage.txt file created.");

            }else {
                System.out.println("File already exist at location: " + newFile.getCanonicalPath());
            }return newFile;

        } catch (IOException err) {
            throw new DukeException("Failed to create new Storage.txt file.");
        }
    }

    public static File openFile() throws DukeException {
        File newFile = new File("data\\Storage.txt");
        if (!newFile.exists()) {
            try {
                newFile = createNewFile();
            } catch (DukeException e) {
                throw new DukeException("Error! Please verify the path");
            }
        }
        return newFile;
    }

    public static void writeToFile(File fileWrite) {
        try {
            FileWriter fw = new FileWriter(fileWrite, false);
            ArrayList<Task> list = TaskList.taskDisplay;
            for (int i = 0; i < list.size(); i++) {
                Task taskAtIndex = list.get(i);
                String typeCheck = taskAtIndex.getTaskType();
                String newLine = "";
                if (typeCheck.equals("T")) {
                    newLine = outputArray(taskAtIndex);
                } else if (typeCheck.equals("D")) {
                    newLine = outputArray(taskAtIndex);
                } else if (typeCheck.equals("E")) {
                    newLine = outputArray(taskAtIndex);
                }
                fw.write(newLine + System.getProperty("line.separator"));
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Failed to write");
        }
    }

    public static String outputArray(Task targetTask) {
        String wall = " | ";
        String taskType = targetTask.getTaskType();
        String newLine = taskType + wall;
        if (targetTask.isDone) {
            newLine = newLine + "1" + wall;
        } else {
            newLine = newLine + "0" + wall;
        }
        newLine = newLine + targetTask.description;

        if (taskType.equals("D") || taskType.equals("E"))
            newLine = newLine + wall + targetTask.getTaskType();
        return newLine;
    }
}
