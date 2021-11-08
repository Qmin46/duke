package main.duke;
import java.io.IOException;
import java.io.File;
import main.duke.ui.Ui;
import main.duke.command.Parser;

public class Duke {
    /**
     Ui: deals with interactions with the user
     Storage: deals with loading tasks from the file and saving tasks in the file
     Parser: deals with making sense of the user command
     TaskList: contains the task list e.g., it has operations to add/delete tasks in the list
     **/

    public static void Proceed() {
        Parser.Command();
        System.out.println(Ui.line);
    }

    public static void RunDuke() {
        Ui.WelcomeDuke();
        Ui.Greet();
    }

    public static void main(String[] args) throws IOException {
        RunDuke();
        Proceed();
    }
}

