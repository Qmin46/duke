//package main.java;

public class List{
    protected String description;
    protected boolean isDone;

    public List(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    public void setDone(boolean done){
        this.isDone = done;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        String print = "[" + getStatusIcon()+"] "+getDescription();
        return print;
    }
}