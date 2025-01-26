import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class NickiMinaj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm NickiMinaj \n" +
                "I am not Jasmine, I am Aladdin");
        System.out.println("Watchu wanna do, Barb?");
        List<String> toDo = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (!(input.equalsIgnoreCase("list"))) {
                toDo.add(input);
            }

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Imma run away Imma run away aye");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                for (int i = 0; i < toDo.size(); i++) {
                    String output = (i + 1) + ". " + toDo.get(i);
                    System.out.println(output);
                }
            } else {
                System.out.println("added:" + input);
            }
        }
        scanner.close();
    }

    /*public static String listToString(List<String> list) {
        for (String task : list) {

        }
    }*/
}
