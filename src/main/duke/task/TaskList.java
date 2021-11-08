package main.duke.task;
import java.util.ArrayList;
import java.lang.String;


public class TaskList {

    static String line = "____________________________________________________________\n";
    static int taskCount = 0;
    static ArrayList<Task> taskDisplay = new ArrayList<>();

    /**
     * Prints the added task.
     *
     * @param newJob The newly added task.
     */
    public static void addTask(Task newJob) {
        taskDisplay.add(newJob);
        taskCount++;
        System.out.println(line + "\nGot it. I've added this task:\n"
                + newJob.getTaskInfo());
    }

    /**
     * Remove the specific task from the schedule.
     *
     * @param input task to be removed.
     */
    public static void removeTask(String input) {
        int index = Integer.parseInt(input.substring(6).trim()) - 1;
        taskCount--;
        System.out.println(line + "\nNoted. I've removed this task: \n"
                + " " + taskDisplay.get(index).getStatusIcon() + " " + taskDisplay.get(index).description
                + "\nNow you have " + taskCount + " tasks in the list.");
        taskDisplay.remove(index);
    }

    /** Print array size.*/
    public int getListSize() { return taskDisplay.size(); }

    /** Print all the tasks that already input.*/
    public static void printCheckList() {
        System.out.println(line + "\nHere are the tasks in your list:");
        for (int i = 0; i < taskDisplay.size(); i++) {
            System.out.println((i+1) + "." + taskDisplay.get(i).getTaskInfo());
        }
        System.out.println(line);
    }

    /**
     * Mark the specific task as completed in the schedule.
     *
     * @param input task to be marked as done.
     */
    public static void markIndex(String input) {
        int index = Integer.parseInt(input.substring(4).trim()) - 1;
        if (index < taskCount) {
            markTask(taskDisplay.get(index));
            System.out.println(line + "Nice! I've marked this task as done:\n  "
                     +taskDisplay.get(index).getTaskInfo());
        } else {
            System.out.println(line + "\nInvalid task index number\n" + line);
        }
    }

    public static void markTask(Task inputTask) {
        inputTask.markCompleted();
    }

    public static void printTaskCount() {
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }

    /**
     * Find the specific task based on keyword input by user.
     *
     * @param input keyword to search.
     */
    public static void findTask(String input){
        boolean isFound = false;
        String[] parts = input.substring(4).split(" ");
        String details = parts[1].trim();
        for (int i = 0; i < taskDisplay.size(); i++) {
            Task task = taskDisplay.get(i);
            if (task.getDescription().toLowerCase().contains(details.toLowerCase())) {
                isFound = true;
                break;
            }
            assert false;
        }

        if (isFound) {
            System.out.println("Here are the matching tasks in your list!");
            for (int i = 0; i < taskDisplay.size(); i++) {
                Task task = taskDisplay.get(i);
                if (task.getDescription().toLowerCase().contains(details.toLowerCase())) {
                    System.out.println(i + 1 + ". " + task.getTaskInfo());
                }
            }
        } else if (taskDisplay.size() == 0) {
            System.out.println(line + "Sorry, you don't have any task in your list!");
        } else {
            Task task = taskDisplay.get(0);
            System.out.println(line + "There is no task found!");
            System.out.println(line + input);
            System.out.println(line + task.toString().toLowerCase());
        }

    }

}
