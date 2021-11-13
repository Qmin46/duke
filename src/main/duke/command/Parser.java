package main.duke.command;
import main.duke.DukeExceptionMeaning;
import main.duke.task.Deadline;
import main.duke.task.Event;
import main.duke.task.TaskList;
import main.duke.task.ToDo;
import main.duke.ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * A <code>Parser</code> deals with making sense of the user command.
 */
public class Parser {
    static Scanner in = new Scanner(System.in);

    public static void Command() {
        Boolean stop = false;
        try {
            while (!stop) {
                String input = in.nextLine();
                if (input.equals("bye")) {
                    Ui.Echo();
                    stop = true;
                } else if (input.equals("guide")){
                    Ui.Guide();
                }
                else if (input.equals("list")) {
                    TaskList.printCheckList();
                } else if (input.contains("todo") && (input.substring(0, 4)).equals("todo")) {
                    if (input.length() < 5 || input.substring(4).trim().equals("")) {
                        System.out.println(Ui.line + "☹ OOPS!!! The description of a todo cannot be empty.\n" + Ui.line);
                    } else {
                        String newTask = input.substring(4).trim();
                        ToDo newTodo = new ToDo(newTask);
                        TaskList.addTask(newTodo);
                        TaskList.printTaskCount();
                        System.out.println(Ui.line);
                    }

                } else if (input.contains("deadline") && (input.substring(0, 8)).equals("deadline")) {
                    if (input.contains("/by")) {
                        String[] parts = input.substring(8).split("/by");
                        String[] dateTime = parts[1].trim().split(" ");
                        String[] split = dateTime[0].split("/");
                        if (checkDateValidity(split)) {
                            LocalDate taskDate = formatDate(split);
                            if (dateTime.length == 2 && checkTimeValidity(split[1])) {
                                LocalTime taskTime = formatTime(dateTime[1]);
                                Deadline newDeadline = new Deadline(parts[0].trim(), taskDate, taskTime);
                                TaskList.addTask(newDeadline);
                                TaskList.printTaskCount();
                                System.out.println(Ui.line);
                            } else {
                                Deadline newDeadline = new Deadline(parts[0].trim(), taskDate);
                                TaskList.addTask(newDeadline);
                                TaskList.printTaskCount();
                                System.out.println(Ui.line);
                            }
                        } else {
                                Deadline newDeadline = new Deadline(parts[0].trim(), parts[1].trim());
                                TaskList.addTask(newDeadline);
                                TaskList.printTaskCount();
                                System.out.println(Ui.line);
                        }
                    } else if (input.length() < 9 || input.substring(8).trim().equals("")){
                        System.out.println(Ui.line + "☹ OOPS!!! The description of a deadline cannot be empty.\n" + Ui.line);
                    }
                } else if (input.contains("event") && (input.substring(0, 5)).equals("event")) {
                    if (input.contains("/at")) {
                        String[] parts = input.substring(5).split("/at");
                        String[] dateTime = parts[1].trim().split(" ");
                        String[] split = dateTime[0].split("/");
                        if (checkDateValidity(split)) {
                                LocalDate taskDate = formatDate(split);
                                if (dateTime.length == 2 && checkTimeValidity(split[1])) {
                                    LocalTime taskTime = formatTime(dateTime[1]);
                                    Event newEvent = new Event(parts[0].trim(), taskDate, taskTime);
                                    TaskList.addTask(newEvent);
                                    TaskList.printTaskCount();
                                    System.out.println(Ui.line);
                                }else {
                                    Event newEvent = new Event(parts[0].trim(), taskDate);
                                    TaskList.addTask(newEvent);
                                    TaskList.printTaskCount();
                                    System.out.println(Ui.line);
                                }
                        } else {
                            Event newEvent = new Event(parts[0].trim(), parts[1].trim());
                            TaskList.addTask(newEvent);
                            TaskList.printTaskCount();
                            System.out.println(Ui.line);
                        }
                    } else if (input.length() < 6 || input.substring(5).trim().equals("")){
                        System.out.println(Ui.line + "☹ OOPS!!! The description of a event cannot be empty.\n" + Ui.line);
                    }
                } else if (input.contains("done") && (input.substring(0, 4)).equals("done")) {
                    TaskList.markIndex(input);
                    System.out.println(Ui.line);

                } else if (input.contains("delete") && (input.substring(0, 6)).equals("delete")) {
                    TaskList.removeTask(input);
                    System.out.println(Ui.line);
                } else if (input.contains("find") && (input.substring(0, 4)).equals("find"))  {
                    TaskList.findTask(input);
                    System.out.println(Ui.line);
                } else {
                    System.out.println(Ui.line);
                    throw new DukeExceptionMeaning();
                }
            }
        } catch(DukeExceptionMeaning e) {
            System.out.println( "☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    public static boolean checkTimeValidity(String timeInput) {
        if (timeInput.equals("")) {
            return false;
        } else {
            int time = Integer.parseInt(timeInput);
            int hour = time/100;
            int min = time%100;
            if (hour < 24 && hour >= 0 && min < 60 && min >= 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static LocalTime formatTime(String timeInput) {
        int time = Integer.parseInt(timeInput);
        int hour = time /100;
        int min = time%100;
        LocalTime taskTime = LocalTime.of(hour , min);
        return taskTime;
    }

    public static boolean checkDateValidity(String[] details) {
        if (details.length != 3) {
            return false;
        } else {
            int day = Integer.parseInt(details[0].trim());
            int month = Integer.parseInt(details[1].trim());
            int year = Integer.parseInt(details[2].trim());
            if (day <= 31 || day >= 1) {
                return true;
            } else if (month <= 12 || month >= 1) {
                return true;
            } else if (year > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static LocalDate formatDate(String[] details) {
        String day = details[0].trim();
        if (day.length() == 1) {
            day = "0" + day;
        }
        assert false;
        String month = details[1].trim();
        if (month.length() == 1) {
            month = "0" + month;
        }
        assert false;
        String year = details[2].trim();
        if (year.length() < 4) {
            for (int i = year.length(); i < 4; i ++) {
                year = "0" + year;
            }
        }
        assert false;
        String newDateFormat = year + "-" + month + "-" + day;
        LocalDate taskDate = LocalDate.parse(newDateFormat);
        return taskDate;
    }

}

