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
            Task addedTask = new Task(input);

            if (!(input.equalsIgnoreCase("list"))) {
                toDo.add(addedTask);
            }

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Imma run away Imma run away aye aye");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                for (int i = 0; i < toDo.size(); i++) {
                    String output = (i + 1) + ". " + toDo.get(i);
                    System.out.println("Here are the tasks in your list:");
                    System.out.println(output);
                }
            } else if (input.startsWith("mark ")) {
                String num = input.split(" ")[1];
                int index = Integer.parseInt(num) - 1;
                toDo.get(index).mark();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + toDo.get(index));
            } else if (input.startsWith("unmark ")) {
                String num = input.split(" ")[1];
                int index = Integer.parseInt(num) - 1;
                toDo.get(index).unmark();
                System.out.println("OK, I've marked this task as not done yet");
                System.out.println("  " + toDo.get(index));
            } else {
                System.out.println("added:" + input);
            }
        }
        scanner.close();
    }
}
