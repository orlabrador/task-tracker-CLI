import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskController {

    private List<Task> tasks;

    public TaskController() {
        this.tasks = loadTasks();
    }
    
    private List<Task> loadTasks() {
        List<Task> stored_tasks = new ArrayList<>();
        return stored_tasks;
    }
    public void addTask(String description) {
        Task new_task = new Task(description);
        tasks.add(new_task);
        System.out.println("Task added succesfully (ID: " + new_task.getId() + ")");
    }


    private Optional<Task> findTask(String id) {
        return tasks.stream()
        .filter((x -> x.getId() == Integer.parseInt(id)))
        .findFirst();
    }
}
