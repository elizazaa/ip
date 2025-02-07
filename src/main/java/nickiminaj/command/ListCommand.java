package nickiminaj.command;

import nickiminaj.Storage;
import nickiminaj.TaskList;
import nickiminaj.Ui;
import nickiminaj.command.Command;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.listTasks();
    }
}

