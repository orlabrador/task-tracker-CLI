public class TaskApp {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        
        if (args.length < 1) {
            System.out.println("format: TaskApp <command> [arguments]");
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Error: make sure instruction format is correct");
                    System.out.println("format: TaskApp add [arguments]");
                    return;
                }
                taskController.addTask(args[1]);
                System.out.println("Task added succesfully (ID:" + args[1] + ")");
                break;
            
            case "update":
                if (args.length < 3) {
                    System.out.println("Error: make sure instruction format is correct");
                    System.out.println("format: TaskApp update <id> <new description>");
                }
                taskController.updateTask(args[1], args[2]);
                System.out.println("Task updated succesfully (ID:" + args[1] + ")");
                break;
        
            case "delete":
                if (args.length < 2) {
                    System.out.println("Error: make sure instruction format is correct");
                    System.out.println("format: TaskApp delete <id>");
                    return;
                }
                taskController.deleteTask(args[1]);
                System.out.println("Task deleted succesfully (ID:" + args[1] + ")");
                break;
            
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Error: make sure instruction format is correct");
                    System.out.println("format: TaskApp mark-in-progress <id>");
                return;
                }
                taskController.markInProgress(args[1]);
                System.out.println("Task status updated as in progress (ID:" + args[1] + ")");
                break;

            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Error: make sure instruction format is correct");
                    System.out.println("format: TaskApp mark-done <id>");
                return;
                }
                taskController.markDone(args[1]);
                System.out.println("Task status updates as done (ID:" + args[1] + ")");
                break;
            
            case "list":
                if (args.length < 2) {
                    taskController.listTasks("All");
                } else {
                    Status filterStatus;
                    try {
                        filterStatus = Status.valueOf(args[1].toUpperCase().replace("-", "_"));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid status: " + args[1]);
                        return;
                    }
                    taskController.listTasks(filterStatus.toString());
                }
                break;

            default:
                System.out.println("Unrecognized command:" + command);
                break;

        }
        taskController.saveTasks();
    }
}
