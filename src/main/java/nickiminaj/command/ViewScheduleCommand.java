package nickiminaj.command;


import nickiminaj.NickiMinajException;
import nickiminaj.Storage;
import nickiminaj.TaskList;
import nickiminaj.Ui;
import nickiminaj.tasks.Task;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

public class ViewScheduleCommand extends Command {
    private LocalDate date;

    public ViewScheduleCommand(String date) throws NickiMinajException {
        try {
            this.date = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new NickiMinajException("Invalid date format! Please use YYYY-MM-DD.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NickiMinajException {
        List<Task> scheduledTasks = tasks.getTasks().stream()
                .filter(task -> task.isOnDate(date))
                .collect(Collectors.toList());

        if (scheduledTasks.isEmpty()) {
            ui.showError("No tasks scheduled for " + date + ".");
        } else {
            TaskList filteredTaskList = new TaskList(scheduledTasks);
            ui.showMatchingTasks(filteredTaskList);
        }
    }
}

