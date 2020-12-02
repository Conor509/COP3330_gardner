import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @org.junit.jupiter.api.Test
    void testingIfItemIsIncompleted() {
        assertEquals(true, TaskList.checkIncomplete("*** ", ""));
    }

    @org.junit.jupiter.api.Test
    void testingIfItemIsCompleted() {
        assertEquals(false, TaskList.checkIncomplete("*** ", "*** "));
    }

    @org.junit.jupiter.api.Test
    void testInvalidDueDate(){
        assertEquals(false, TaskItem.checkDate("[1999-11-17]"));
    }

    @org.junit.jupiter.api.Test
    void testValidDueDate(){
        assertEquals(true, TaskItem.checkDate("[2021-11-17]"));
    }

    @org.junit.jupiter.api.Test
    void testInvalidTitle(){
        assertEquals(false, TaskItem.checkTitle(""));
    }

    @org.junit.jupiter.api.Test
    void testValidTitle(){
        assertEquals(true, TaskItem.checkTitle("Eggs"));
    }

    @org.junit.jupiter.api.Test
    void testIfListWasSaved(){
        assertEquals(true, TaskList.saveList());
    }

    @Test
    void testEmptyList(){
        try {
            assertEquals(true, TaskList.checkEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}