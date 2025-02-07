import java.util.Scanner;

public class NickiMinaj {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public NickiMinaj(String filePath) {
        this.ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.loadTasks());
    }

    public void run() {
        ui.showWelcome();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = ui.readCommand();

            if (input.equalsIgnoreCase("bye")) {
                ui.showExitMessage();
                break;
            } else if (input.equalsIgnoreCase("list")) {
                tasks.listTasks();
            } else if (input.startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks.markTask(index);
                storage.saveTasks(tasks.getTasks());
                ui.showMarkedTask(tasks.getTask(index));
            } else if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks.unmarkTask(index);
                storage.saveTasks(tasks.getTasks());
                ui.showUnmarkedTask(tasks.getTask(index));
            } else if (input.startsWith("todo")) {
                String description = input.substring(5);
                Task newTask = new Todo(description);
                tasks.addTask(newTask);
                storage.saveTasks(tasks.getTasks());
                ui.showAddedTask(newTask, tasks.getSize());
            } else if (input.startsWith("deadline")) {
                String[] parts = input.substring(9).split(" /by ");
                Task newTask = new Deadline(parts[0], parts[1]);
                tasks.addTask(newTask);
                storage.saveTasks(tasks.getTasks());
                ui.showAddedTask(newTask, tasks.getSize());
            } else if (input.startsWith("event")) {
                String[] parts = input.substring(6).split(" /from | /to ");
                Task newTask = new Event(parts[0], parts[1], parts[2]);
                tasks.addTask(newTask);
                storage.saveTasks(tasks.getTasks());
                ui.showAddedTask(newTask, tasks.getSize());
            } else if (input.startsWith("delete")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                Task removedTask = tasks.removeTask(index);
                storage.saveTasks(tasks.getTasks());
                ui.showDeletedTask(removedTask, tasks.getSize());
            } else {
                ui.showError("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
        scanner.close();
    }


    public static void main(String[] args) {
        new NickiMinaj("./data/NickiMinaj.txt").run();
    }
}