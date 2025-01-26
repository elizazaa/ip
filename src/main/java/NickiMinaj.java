import java.util.Scanner;
public class NickiMinaj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm NickiMinaj \n" +
                "I am not Jasmine, I am Aladdin");
        System.out.println("Are these the things that I get for pulling you students on?");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println("gurl bye");
                break;
            }
            System.out.println(input);
        }
        scanner.close();
    }
}
