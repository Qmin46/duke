package main.duke.task;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    @Test
    public void addTaskList_success() {
        TaskList taskList = new TaskList();
        assertEquals(0, taskList.getListSize());
        taskList.addTask(new Task("random task"));
        assertEquals(1, taskList.getListSize());
    }
}


