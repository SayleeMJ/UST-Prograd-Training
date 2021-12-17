import java.util.*;

public class ToDoList {

      PriorityQueue<String> todoListCompleted = new PriorityQueue<String>();
      PriorityQueue<String> todoListNotCompleted = new PriorityQueue<String>();
      PriorityQueue<String> todoList = new PriorityQueue<String>();
      ArrayList<String> removedList = new ArrayList<>();

      public void addItemsToList(String item, boolean status) {
            if (status) {
                  todoListCompleted.add(item);
                  todoList.addAll(todoListCompleted);
            } else {
                  todoListNotCompleted.add(item);
                  todoList.addAll(todoListNotCompleted);
            }
      }

      public String checkToDoList(String item) {
            String existingItem = null;
            for (String list : todoList) {
                  if (list == item) {
                        existingItem = item;
                        break;
                  }
            }
            return existingItem;
      }


      public boolean removeFromToDoList(String item) {
            return todoList.removeIf(list -> list == item);
      }


      public boolean retrieveRemovedItemFromToDoList(String item) {
            boolean task = false;
            removedList.add(item);
            todoList.removeIf(list -> list == item);
            todoList.addAll(removedList);
            if (todoList.contains(item)) {
                  task = true;
            }
            return task;
      }

      public boolean taskCompletedOrNotCompleted(String status) {
            boolean task = false;
            for (String list : todoListCompleted) {
                  if (list == status) {
                        task = true;
                  }
            }
            for (String list : todoListNotCompleted) {
                  if (list == status) {
                        task = false;
                  }
            }
            return task;
      }
}


/*
1. As a note keeper I want to add items to my todo list.
2. As a note keeper I want to remove items from my todo list.
3. As a note keeper, I want to be able to bring back the removed items. (un remove)
4. As a note keeper, I want to toggle between completed and not completed.
*/
