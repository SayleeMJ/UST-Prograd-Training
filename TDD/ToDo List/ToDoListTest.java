import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    ToDoList toDoList = new ToDoList();

    @BeforeEach
    public void addItemsToList() {
        toDoList.addItemsToList("Buy Milk",true);
        toDoList.addItemsToList("Buy Sugar",false);
        toDoList.addItemsToList("Buy Tea-powder",true);
        toDoList.addItemsToList("Drink Tea",false);
    }

    @Test
    @DisplayName("ADDING ITEM IN DO-TO LIST")
    public void addItemsToTodoListTest() {
        String actualList = toDoList.checkToDoList("Buy Milk");
        assertEquals("Buy Milk", actualList);
    }

    @Test
    @DisplayName("REMOVING ITEM FROM DO-TO LIST")
    public void removeItemsFromTodoListTest() {
        boolean actualList = toDoList.removeFromToDoList("Drink Tea");
        assertEquals(true, actualList);
    }

    @Test
    @DisplayName("RETRIEVING REMOVED ITEM FROM DO-TO LIST")
    public void unRemoveItemsFromTodoListTest() {
        boolean actualList = toDoList.retrieveRemovedItemFromToDoList("Drink Tea");
        assertEquals(true, actualList);
    }

    @Nested
    public class toggleBetweenCompletedAndNotCompletedTodoListTest {

        @Test
        @DisplayName("CHECKING THAT TASK IS COMPLETED")
        public void checkIfTaskIsCompleted() {
            boolean actualList = toDoList.taskCompletedOrNotCompleted("Buy Milk");
            assertEquals(true, actualList);
        }

        @Test
        @DisplayName("CHECKING THAT TASK IS NOT-COMPLETED")
        public void checkIfTaskIsNotCompleted() {
            boolean actualList = toDoList.taskCompletedOrNotCompleted("Drink Tea");
            assertEquals(false, actualList);
        }
    }
}