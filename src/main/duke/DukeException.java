package main.duke;

public class DukeException extends Exception{
    protected String errMsg;

    public DukeException() {
        this.errMsg = "";
    }

    public DukeException(String invalid) {
        this.errMsg = invalid;
    }

    public void printErrMsg() {
        System.out.println(errMsg);
    }

}