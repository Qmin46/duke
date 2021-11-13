package main.duke.ui;

/**
 * A <code>TaskList</code> deals with interactions with the user.
 */
public class Ui {

    public static String line ="____________________________________________________________\n";

    public static void showLine() {
        System.out.println("____________________________________________________________\n");
    }

    /** Prints welcome message. */
    public static void WelcomeDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Welcome to\n" + logo);
    }

    /** Prints greeting message. */
    public static void Greet() {
        String start = "Hello, I'm Duke\n";
        String end = "What can I do for you?\n";
        String guide = "Note: Type 'guide' for more information.\n";
        System.out.println(line + start + end + guide + line);
    }

    /** Display the commands available for the user. */
    public static void Guide(){
        System.out.println(line);
        System.out.println("Here are the commands available: ");
        System.out.println("To view existing tasks:             list");
        System.out.println("To add a new to do job:             todo {description}");
        System.out.println("To add a new deadline:              deadline {description} /by {yyyy-MM-dd HHmm}");
        System.out.println("To add a new event:                 event {description} /at {yyyy-MM-dd HHmm}{time} - {yyyy-MM-dd HHmm}{time}");
        System.out.println("To mark a task as completed:        done {taskSequence (please have it in number)}");
        System.out.println("To delete a task:                   delete {taskSequence (please have it in number)}");
        System.out.println("To search task by keyword:          find {keyword (please have it in number)}");
        System.out.println("To exit this chat bot:              bye");
        System.out.println(line);
    }

    /** Prints exit message. */
    public static void Echo(){
        System.out.println(line + "Bye. Hope to see you again!");
    }

}


