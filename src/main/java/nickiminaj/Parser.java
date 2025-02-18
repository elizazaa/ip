package nickiminaj;

import nickiminaj.command.AddCommand;
import nickiminaj.command.ByeCommand;
import nickiminaj.command.DeleteCommand;
import nickiminaj.command.ListCommand;
import nickiminaj.command.MarkCommand;
import nickiminaj.command.UnmarkCommand;
import nickiminaj.command.InspireCommand;
import nickiminaj.command.Command;
import nickiminaj.tasks.Deadline;
import nickiminaj.tasks.Event;
import nickiminaj.tasks.Todo;

public class Parser {
    public static Command parse(String input) throws DukeException {
        assert input != null : "Error: Input cannot be null!";

        String[] parts = input.split(" ", 2);
        assert parts.length > 0 : "Error: Command cannot be empty!";

        String commandType = parts[0];
        String argument = (parts.length > 1) ? parts[1].trim() : "";

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
            assert !argument.isEmpty() : "Error: 'todo' command requires a description!";
            return new AddCommand(new Todo(argument));
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
        case "inspire":
            return new InspireCommand();
        // Fallthrough
        default:
            throw new DukeException("I don't even know what that means... but it sounds mad iconic.");
        }
    }
}
