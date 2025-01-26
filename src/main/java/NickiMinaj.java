import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class NickiMinaj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm NickiMinaj \n" +
                "I am not Jasmine, I am Aladdin");
        System.out.println("Watchu wanna do, Barb?");

        while (true) {
            String input = scanner.nextLine();

            List<String> toDo = new ArrayList<>();
            toDo.add(input);

            if (input.equals("bye")) {
                System.out.println("Imma run away Imma run away aye");
                break;
            } else if (input.equals("list")) {
                for (String task : toDo) {
                    System.out.println(task);
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
