package nickiminaj.command;

import nickiminaj.*;
import nickiminaj.tasks.Task;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        storage.saveTasks(tasks.getTasks());
        ui.showAddedTask(task, tasks.getSize());
    }
}
