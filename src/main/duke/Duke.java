package main.duke;

import main.duke.command.Parser;
import main.duke.task.Storage;
import main.duke.ui.Ui;

import java.io.File;
import java.io.IOException;

/**
 * A duke class to run the chatbot.
 */
public class Duke {

    public static void Proceed() {
        Parser.Command();
        System.out.println(Ui.line);
    }

    public static void RunDuke() {
        try {
            boolean isSuccess = false;
            File StorageFile = Storage.openFile();
           // Storage.ReadFileToArray(StorageFile);
            isSuccess = true;

        }catch (DukeException e) {
            e.printErrMsg();
        }

        Ui.WelcomeDuke();
        Ui.Greet();
    }

    public static void main(String[] args) throws IOException {
        RunDuke();
        Proceed();

        try {
            Storage.writeToFile(Storage.openFile());
        } catch (DukeException e) {
            System.out.println("Failed to write to file");
        }
    }

    public String reply(String input) {
            Parser.Command();
            return input;
    }
}


