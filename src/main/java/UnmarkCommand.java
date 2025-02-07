public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.unmarkTask(index);
        storage.saveTasks(tasks.getTasks());
        ui.showUnmarkedTask(tasks.getTask(index));
    }
}
