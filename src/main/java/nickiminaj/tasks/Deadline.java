package nickiminaj.tasks;

import nickiminaj.tasks.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {
    private final LocalDateTime by;

    /**
     * Constructs a Deadline task with the specified description and deadline date.
     *
     * @param description The description of the task.
     * @param by The deadline in string format (d/M/yyyy HHmm).
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = parseDateTime(by);
    }

    /**
     * Constructs a Deadline task with the specified description, deadline date, and completion status.
     *
     * @param description The description of the task.
     * @param by The deadline as a LocalDateTime object.
     * @param isDone The completion status of the task.
     */
    public Deadline(String description, LocalDateTime by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Parses a date-time string into a LocalDateTime object.
     *
     * @param dateTime The date-time string in the format d/M/yyyy HHmm.
     * @return The parsed LocalDateTime object.
     */
    private LocalDateTime parseDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return LocalDateTime.parse(dateTime, formatter);
    }

    /**
     * Returns the string representation of the deadline task.
     *
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy, h:mma");
        return "[D][" + (isDone ? "✓" : "✗") + "] " + description + " (by: " + by.format(formatter) + ")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String serialize() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by.format(formatter);
    }


}
