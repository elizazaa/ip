package nickiminaj.command;

import nickiminaj.DukeException;
import nickiminaj.Storage;
import nickiminaj.TaskList;
import nickiminaj.Ui;

public class InspireCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.showInspiration();
    }
}
