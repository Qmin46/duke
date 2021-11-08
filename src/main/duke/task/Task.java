package main.duke.task;

public class Task {

    protected String description;
    protected boolean isDone;
    protected String type;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        //return (isDone ? "[X]" : " "); // mark done task with X
        if (isDone) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    public String getTaskInfo() {
        String TaskInfo = this.getStatusIcon() + " " + description;
        return TaskInfo;
    }

    public void markCompleted() {
        isDone = true;
    }

    public String getTaskType() {
        return "";
    }

}

