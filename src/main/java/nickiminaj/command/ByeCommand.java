package nickiminaj.command;

import nickiminaj.Storage;
import nickiminaj.TaskList;
import nickiminaj.Ui;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showExitMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
