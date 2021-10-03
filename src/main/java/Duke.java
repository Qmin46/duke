
package main.java;

import java.util.Scanner;

public class Duke {
    static Scanner WordScan = new Scanner(System.in);
    static String separator = "____________________________________________________________\n";
    static String[] list = new String[100];
    static int listCount = 0;
    static Task[] Checklist = new Task[100];
    static int TaskCount = 0;


    public static void WelcomeDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Welcome to\n" + logo);
    }

    public static void Hello() {
        String start = "Hello! I'm Duke\n";
        String question = "What can I do for you?\n";
        System.out.println(separator + start + question + separator);
    }

    public static void Bye() {
        Boolean stop = false;
        while (stop == false) {
            String word = WordScan.nextLine();
            if (word.equals("bye")) {
                System.out.println(separator + "Bye. Hope to see you again!\n" + separator);
                stop = true;
            } else {
                System.out.println(separator + word + "\n" + separator);
            }
        }
    }
    public static void Level1() {
        Hello();
        Bye();
    }
    public static void main(String[] args) {
        WelcomeDuke();
        Level1();
    }
}


