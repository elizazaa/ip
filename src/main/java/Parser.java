public class Parser {
    public static Command parse(String input) throws DukeException {
        String[] parts = input.split(" ", 2);
        String commandType = parts[0];

        switch (commandType) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(Integer.parseInt(parts[1]) - 1);
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(parts[1]) - 1);
            case "todo":
                return new AddCommand(new Todo(parts[1]));
            case "deadline":
                String[] deadlineParts = parts[1].split(" /by ");
                return new AddCommand(new Deadline(deadlineParts[0], deadlineParts[1]));
            case "event":
                String[] eventParts = parts[1].split(" /from | /to ");
                return new AddCommand(new Event(eventParts[0], eventParts[1], eventParts[2]));
            case "delete":
                return new DeleteCommand(Integer.parseInt(parts[1]) - 1);
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
