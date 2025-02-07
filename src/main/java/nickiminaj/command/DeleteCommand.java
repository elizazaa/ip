package nickiminaj.command;

import nickiminaj.*;
import nickiminaj.tasks.Task;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task removedTask = tasks.removeTask(index);
        storage.saveTasks(tasks.getTasks());
        ui.showDeletedTask(removedTask, tasks.getSize());
    }
}
