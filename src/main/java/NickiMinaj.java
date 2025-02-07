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

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command command = Parser.parse(fullCommand); // Get Command object
                command.execute(tasks, ui, storage); // Execute command
                isExit = command.isExit(); // Check if exit command
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new NickiMinaj("./data/NickiMinaj.txt").run();
    }
}