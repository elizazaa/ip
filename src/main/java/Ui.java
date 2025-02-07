import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println("Hello! I'm NickiMinaj\nI am not Jasmine, I am Aladdin");
        System.out.println("Watchu wanna do, Barb?");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showExitMessage() {
        System.out.println("Imma run away Imma run away aye aye");
    }

    public void showLoadingError() {
        System.out.println("OOPS!!! Error loading tasks.");
    }

    public void showError(String message) {
        System.out.println("OOPS!!! " + message);
    }

    public void showMarkedTask(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    public void showUnmarkedTask(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    public void showAddedTask(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showDeletedTask(Task task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }
}
