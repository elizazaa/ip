package nickiminaj.tasks;

import nickiminaj.tasks.Task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
    @Override
    public String serialize() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
