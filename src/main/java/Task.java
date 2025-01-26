public class Task {
    private String toDo;
    private boolean isDone;
    public Task(String description) {
        this.toDo = description;
        this.isDone = false;
    }

    public void mark() {
        isDone = true;
    }

    public void unMark() {
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // X for done, blank for not done
    }
    
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + toDo;
    }
}
