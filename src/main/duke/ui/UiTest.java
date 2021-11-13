package main.duke.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream original = System.out;


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(original);
    }

    @Test
    public void testShowLine(){
        Ui.showLine();
        assertEquals("____________________________________________________________",
                output.toString().trim());
    }
}

