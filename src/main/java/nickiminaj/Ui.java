package nickiminaj;

import nickiminaj.tasks.Task;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println("Hello! I'm nickiminaj.NickiMinaj\nI am not Jasmine, I am Aladdin");
        System.out.println("Watchu wanna do, Barb?");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showExitMessage() {
        System.out.println("Imma run away Imma run away aye aye");
    }

    public void showError(String message) {
        System.out.println("Gurl..." + message);
    }

    public void showMarkedTask(Task task) {
        System.out.println("Okay queen, I gotchu! Task marked ✅");
        System.out.println("  " + task);
    }

    public void showUnmarkedTask(Task task) {
        System.out.println("Unmarked! Ain’t nobody got time for that. ⏳");
        System.out.println("  " + task);
    }

    public void showAddedTask(Task task, int size) {
        System.out.println("Ooo, a new task? Slay! Adding it to the list 📝✨");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showDeletedTask(Task task, int size) {
        System.out.println("Deleted! We don’t need that negativity. ❌💅");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showMatchingTasks(TaskList Tasks) {
        if (Tasks.getSize() == 0) {
            System.out.println("Ain’t nothin’ here");
        } else {
            System.out.println("Chile, let’s see what’s giving today. Here's your Tasks:");
            for (int i = 0; i < Tasks.getSize(); i++) {
                System.out.println((i + 1) + ". " + Tasks.getTask(i));
            }
        }
    }
}
