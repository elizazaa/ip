package nickiminaj;

import nickiminaj.command.AddCommand;
import nickiminaj.command.ByeCommand;
import nickiminaj.command.DeleteCommand;
import nickiminaj.command.ListCommand;
import nickiminaj.command.MarkCommand;
import nickiminaj.command.UnmarkCommand;
import nickiminaj.command.Command;
import nickiminaj.tasks.Deadline;
import nickiminaj.tasks.Event;
import nickiminaj.tasks.Todo;

public class Parser {
    public static Command parse(String input) throws DukeException {
        String[] parts = input.split(" ", 2);
        String commandType = parts[0];

        switch (commandType) {
        case "bye":
            return new ByeCommand();
            // Fallthrough
        case "list":
            return new ListCommand();
            // Fallthrough
        case "mark":
            return new MarkCommand(Integer.parseInt(parts[1]) - 1);
            // Fallthrough
        case "unmark":
            return new UnmarkCommand(Integer.parseInt(parts[1]) - 1);
            // Fallthrough
        case "todo":
            return new AddCommand(new Todo(parts[1]));
            // Fallthrough
        case "deadline":
            String[] deadlineParts = parts[1].split(" /by ");
            return new AddCommand(new Deadline(deadlineParts[0], deadlineParts[1]));
            // Fallthrough
        case "event":
            String[] eventParts = parts[1].split(" /from | /to ");
            return new AddCommand(new Event(eventParts[0], eventParts[1], eventParts[2]));
            // Fallthrough
        case "delete":
            return new DeleteCommand(Integer.parseInt(parts[1]) - 1);
            // Fallthrough
        default:
            throw new DukeException("I don't even know what that means... but it sounds mad iconic.");
        }
    }
}
