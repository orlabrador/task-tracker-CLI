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
                    System.out.println("Error: make sure format of instruction is correct");
                    System.out.println("format: TaskApp add [arguments]");
                    return;
                }
                taskController.addTask(args[1]);
                break;
            
            case "update":
                break;
        
            case "delete":
                break;

            default:
                break;

            
        }
    }
}
