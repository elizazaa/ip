package nickiminaj.command;

import nickiminaj.TaskList;
import nickiminaj.Ui;
import nickiminaj.Storage;
import nickiminaj.tasks.Task;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        storage.saveTasks(tasks.getTasks());
        ui.showAddedTask(task, tasks.getSize());
    }
}
