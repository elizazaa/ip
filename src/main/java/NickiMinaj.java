import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class NickiMinaj {
    private static Storage storage;
    private static List<Task> toDo;
    public static void main(String[] args) {
        storage = new Storage("./data/NickiMinaj.txt");
        toDo = storage.loadTasks();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm NickiMinaj\n" +
                "I am not Jasmine, I am Aladdin");
        System.out.println("Watchu wanna do, Barb?");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Imma run away Imma run away aye aye");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < toDo.size(); i++) {
                    String output = (i + 1) + ". " + toDo.get(i);
                    System.out.println(output);
                }
            } else if (input.startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                toDo.get(index).mark();
                storage.saveTasks(toDo);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + toDo.get(index));
            } else if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                toDo.get(index).unmark();
                storage.saveTasks(toDo);
                System.out.println("OK, I've marked this task as not done yet");
                System.out.println("  " + toDo.get(index));
            } else if (input.startsWith("todo")) {
                try {
                    String description = input.substring(5);
                    if (description.isEmpty()) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                    }
                    Task newTask = new Todo(description);
                    toDo.add(newTask);
                    storage.saveTasks(toDo);
                    System.out.println("Got it. I've added this task");
                    System.out.println("  " + newTask);
                    System.out.println("Now you have " + toDo.size() + " in the list");
                } catch (DukeException e) {
                    System.out.println("OOPS!!! Please enter the date in the format d/M/yyyy HHmm");
                }
            } else if (input.startsWith("deadline")) {
                try {
                    String[] parts = input.substring(9).split(" /by ");
                    String des = parts[0];
                    if (des.isEmpty()) {
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
                    }
                    Task newTask = new Deadline(parts[0], parts[1]);
                    toDo.add(newTask);
                    storage.saveTasks(toDo);
                    System.out.println("Got it. I've added this task");
                    System.out.println("  " + newTask);
                    System.out.println("Now you have " + toDo.size() + " in the list");
                } catch (DukeException e) {
                    System.out.println("OOPS!!! Please enter the date in the format d/M/yyyy HHmm.");
                }
            } else if (input.startsWith("event")) {
                try {
                    String[] parts = input.substring(6).split(" /from | /to ");
                    String des = parts[0];
                    if (des.isEmpty()) {
                        throw new DukeException("OOPS!!! The description of an event cannot be empty.");
                    }
                    Task newTask = new Event(des, parts[1], parts[2]);
                    toDo.add(newTask);
                    storage.saveTasks(toDo);
                    System.out.println("Got it. I've added this task");
                    System.out.println("  " + newTask);
                    System.out.println("Now you have " + toDo.size() + " in the list");
                } catch (DukeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.startsWith("delete")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= toDo.size()) {
                        throw new DukeException("OOPS!!! The task number you specified is invalid.");
                    }
                    Task removedTask = toDo.remove(index);
                    storage.saveTasks(toDo);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println("  " + removedTask);
                    System.out.println("Now you have " + toDo.size() + " tasks in the list.");
                } catch (NumberFormatException e) {
                    System.out.println("OOPS!!! Please specify a valid task number to delete.");
                } catch (DukeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                } catch (DukeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        scanner.close();
    }
}
