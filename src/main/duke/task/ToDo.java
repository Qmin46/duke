package main.duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
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