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

    public void updateTask(String id, String new_description) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID_" + id + " not found"));
        task.updateDesc(new_description);
    }

    public void deleteTask(String id) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID_" + id + " not found"));
        tasks.remove(task);
    }

    public void markInProgress(String id) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID_" + id + " not found"));
        task.markInprogress();
    }

    public void markDone(String id) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID_" + id + " not found"));
        task.markDone();
    }

    public void listTasks(String type) {
        for (Task task : tasks) {
            String status = task.getStatus().toString().strip();
            if ((type.equals("All")) || status.equals(type)) {
                System.out.println(task.toString());
            }
        }
    }

    private Optional<Task> findTask(String id) {
        return tasks.stream()
        .filter((x -> x.getId() == Integer.parseInt(id)))
        .findFirst();
    }
}
