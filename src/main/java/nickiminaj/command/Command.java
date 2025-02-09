package nickiminaj.command;

import nickiminaj.DukeException;
import nickiminaj.Storage;
import nickiminaj.TaskList;
import nickiminaj.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
    public boolean isExit() {
        return false;
    }
}

