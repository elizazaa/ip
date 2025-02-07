package nickiminaj.command;

import nickiminaj.DukeException;
import nickiminaj.Storage;
import nickiminaj.TaskList;
import nickiminaj.Ui;
import nickiminaj.command.Command;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.markTask(index);
        storage.saveTasks(tasks.getTasks());
        ui.showMarkedTask(tasks.getTask(index));
    }
}