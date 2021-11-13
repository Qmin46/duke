package main.duke.task;
import main.duke.DukeException;


public class Task {

    protected String description;
    protected boolean isDone;
    protected String type;
    protected boolean Completed;

    public Task(String newTask, String toComplete) throws DukeException {
        this.description = newTask;
        if (toComplete.equals("1")){
            this.Completed = true;
        } else if (toComplete.equals("0")) {
            this.Completed = false;
        } else {
            throw new DukeException("Invalid input");
        }
    }
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

    public boolean isCompleted() {
        return Completed;
    }

    public String getDone(){
        if(isDone){
            return "1";
        } else {
            return "0";
        }
    }

    public String getTaskType() {
        return "";
    }

    public String getAdditionalInfo() {
        return "";
    }

}

