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

        assert !commandType.isEmpty() : "Error: Command type should not be empty!";

        switch (commandType) {
        case "bye":
            return new ByeCommand();
            // Fallthrough
        case "list":
            return new ListCommand();
            // Fallthrough
        case "mark":
        case "unmark":
        case "delete":
            return handleTaskModification(commandType, argument);
            // Fallthrough
        case "todo":
            return handleTodo(argument);
            // Fallthrough
        case "deadline":
            return handleDeadline(argument);
            // Fallthrough
        case "event":
            return handleEvent(argument);
            // Fallthrough
        case "inspire":
            return new InspireCommand();
        // Fallthrough
        default:
            throw new DukeException("I don't even know what that means... but it sounds mad iconic.");
        }
    }

    private static Command handleTaskModification(String commandType, String argument) throws DukeException {
        if (argument.isEmpty()) {
            throw new DukeException("Oops! You need to provide a task number.");
        }
        try {
            int taskIndex = Integer.parseInt(argument) - 1;
            assert taskIndex >= 0 : "Error: Task index must be non-negative!";
            return switch (commandType) {
                case "mark" -> new MarkCommand(taskIndex);
                case "unmark" -> new UnmarkCommand(taskIndex);
                case "delete" -> new DeleteCommand(taskIndex);
                default -> throw new DukeException("I don't even know what that means... but it sounds mad iconic.");
            };
        } catch (NumberFormatException e) {
            throw new DukeException("Invalid task number! Please enter a valid number.");
        }
    }

    private static Command handleTodo(String argument) throws DukeException {
        if (argument.isEmpty()) {
            throw new DukeException("Oops! The 'todo' command requires a description.");
        }
        return new AddCommand(new Todo(argument));
    }

    private static Command handleDeadline(String argument) throws DukeException {
        if (!argument.contains(" /by ")) {
            throw new DukeException("Oops! The 'deadline' command must be in the format: deadline TASK /by DATE.");
        }
        String[] parts = argument.split(" /by ", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new DukeException("Oops! You must specify a deadline date.");
        }
        return new AddCommand(new Deadline(parts[0], parts[1]));
    }

    private static Command handleEvent(String argument) throws DukeException {
        if (!argument.contains(" /from ") || !argument.contains(" /to ")) {
            throw new DukeException("Oops! The 'event' command must be in the format: event TASK /from START /to END.");
        }
        String[] parts = argument.split(" /from | /to ", 3);
        if (parts.length < 3 || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new DukeException("Oops! You must specify both start and end times.");
        }
        return new AddCommand(new Event(parts[0], parts[1], parts[2]));
    }
}
