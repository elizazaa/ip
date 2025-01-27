import java.io.*;
import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final String filePath; //stores the path to the file where tasks will be saved

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            //create the file and directories if they don't exist
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Task task = parseTask(line);
                    if (task != null) {
                        tasks.add(task);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.serialize());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        switch (type) {
            case "T":
                return new Todo(parts[2], isDone);
            case "D":
                return new Deadline(parts[2],
                        LocalDateTime.parse(parts[3], DateTimeFormatter.ofPattern("d/M/yyyy HHmm")),
                        isDone);
            case "E":
                return new Event(parts[2],
                        LocalDateTime.parse(parts[3], DateTimeFormatter.ofPattern("d/M/yyyy HHmm")),
                        LocalDateTime.parse(parts[4], DateTimeFormatter.ofPattern("d/M/yyyy HHmm")),
                        isDone);
            default:
                return null;
        }

    }
}