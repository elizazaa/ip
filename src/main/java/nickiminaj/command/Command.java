package nickiminaj.command;

import nickiminaj.DukeException;
import nickiminaj.Storage;
import nickiminaj.TaskList;
import nickiminaj.Ui;

/**
 * An abstract class representing a command that can be executed.
 * Subclasses must implement the {@code execute} method to define
 * specific command behaviors.
 */
public abstract class Command {

    /**
     * Executes the command, performing the necessary actions.
     *
     * @param tasks   The task list that may be modified by the command.
     * @param ui      The user interface to display messages.
     * @param storage The storage system to persist any necessary data.
     * @throws Exception If an error occurs during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Determines whether this command signals the program to exit.
     * By default, commands do not exit the program.
     *
     * @return {@code false} by default, overridden by exit commands.
     */
    public boolean isExit() {
        return false;
    }
}

