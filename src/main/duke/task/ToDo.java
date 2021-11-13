package main.duke.task;

/**
 * A <code>ToDo</code> object stores a todo task.
 * * Extends the <code>Task</code> class.
 */
public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public ToDo (String taskDescription, Boolean isDone){
        super(taskDescription);
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "[T][X]";
        } else {
            return "[T][]";
        }
    }

    public String getTaskInfo() {
        String TaskInfo = this.getStatusIcon() + " " + description;
        return TaskInfo;
    }
}