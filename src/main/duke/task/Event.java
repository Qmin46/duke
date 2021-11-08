package main.duke.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*public class Event extends Task{
    protected String at;
    protected LocalDate date;
    protected LocalTime time;

   /* public Event(String description, String at) {
        super(description);
        this.at = at;
    }*/

public class Event extends Task {
    protected String at;
    protected LocalDate date;
    protected LocalTime time;


    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public Event(String newTask, LocalDate newDate) {
        super(newTask);
        date = newDate;
    }

    public Event(String newTask, LocalDate newDate, LocalTime newTime) {
        super(newTask);
        date = newDate;
        time = newTime;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "[E][X]";
        } else {
            return "[E][]";
        }
    }

    public String getTaskInfo() {
        String info = this.getStatusIcon() + " " + description + " (at: ";
        if (date == null) {
            info = info + at ;
        } else {
            info = info + date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
            if (time != null) {
                info = info + " " + time;
            }
            assert false;
        }
        info = info + ")";
        return info;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

}
