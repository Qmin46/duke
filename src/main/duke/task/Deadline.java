package main.duke.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * A <code>DeadLine</code> object stores a task with deadline.
 * * Extends the <code>Task</code> class.
 */
public class Deadline extends Task{
    protected String by;
    protected LocalDate date;
    protected LocalTime time;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline(String newTask, LocalDate newDate) {
        super(newTask);
        date = newDate;
    }

    public Deadline(String newTask, LocalDate newDate, LocalTime newTime) {
        super(newTask);
        date = newDate;
        time = newTime;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "[D][X]";
        } else {
            return "[D][]";
        }
    }

    public String getTaskInfo() {
        String info = this.getStatusIcon() + " " + description + " (by: ";
        if (date == null) {
            info = info + by ;
        } else {
            info = info + date.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + "u";
            if (time != null) {
                info = info + " " + time;
            }
        }
        info = info + ")";
        return info;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

}
