import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class NickiMinaj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm NickiMinaj \n" +
                "I am not Jasmine, I am Aladdin");
        System.out.println("Watchu wanna do, Barb?");
        List<Task> toDo = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("Imma run away Imma run away aye aye");
                break;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < toDo.size(); i++) {
                    String output = (i + 1) + ". " + toDo.get(i);
                    System.out.println(output);
                }
            } else if (input.startsWith("mark ")) {
                Task addedTask = new Task(input);
                toDo.add(addedTask);
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                toDo.get(index).mark();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + toDo.get(index));
            } else if (input.startsWith("unmark ")) {
                Task addedTask = new Task(input);
                toDo.add(addedTask);
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                toDo.get(index).unmark();
                System.out.println("OK, I've marked this task as not done yet");
                System.out.println("  " + toDo.get(index));
            } else if (input.startsWith("todo ")) {
                String description = input.substring(5);
                Task newTask = new Todo(description);
                toDo.add(newTask);
                System.out.println("Got it. I've added this task");
                System.out.println("  " + newTask);
                System.out.println("Now you have " + toDo.size() + "in the list");
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                Task newTask = new Deadline(parts[0], parts[1]);
                toDo.add(newTask);
                System.out.println("Got it. I've added this task");
                System.out.println("  " + newTask);
                System.out.println("Now you have " + toDo.size() + "in the list");
            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from | /to ");
                Task newTask = new Event(parts[0], parts[1], parts[2]);
                toDo.add(newTask);
                System.out.println("Got it. I've added this task");
                System.out.println("  " + newTask);
                System.out.println("Now you have " + toDo.size() + "in the list");
            } else {
                System.out.println("added:" + input);
            }
        }
        scanner.close();
    }
}
