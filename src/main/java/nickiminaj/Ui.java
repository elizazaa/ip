package nickiminaj;

import nickiminaj.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Ui {
    private Scanner scanner;

    private static final List<String> INSPIRATIONAL_QUOTES = new ArrayList<>(List.of(
            "I came to win, to fight, to conquer, to thrive… but honestly, I also came for the snacks.",
            "Bad gyal don't die, die, die\n" +
                    "Hundred rounds on that, grrah-ta-ta",
            "You done, you tight? You suck at life?\n" +
                    "You done suffered twice\n" +
                    "Wo-wo-worship the queen and you might could pass",
            "You wanna know what scares people? Success. You wanna know what scares me? Running out of lashes before a big event.",
            "I don’t chase men. I replace them. Like Wi-Fi networks when the signal gets weak.",
            "They can imitate you, but they can’t duplicate you. Trust me, I tried to clone myself once.",
            "I'm the queen of rap, young Ariana run pop",
            "Pull up in the monster, automobile gangsta \n With a bad queen that came from School of Computing",
            "I am not Jasmine, I am Aladdin / So far ahead, these bums is laggin",
            "Here go some haterade, get your thirst quenched\n" +
                    "Style'd on 'em in this Burberry trench\n" +
                    "These birds copy every word, every inch\n" +
                    "But gang-gang got the hammer and the wrench (brrt)",
            "How many of them could've did it with finesse?\n" +
                    "Now everybody like, \"She really is the best\"\n" +
                    "You play checkers, couldn't beat me playin' chess",
            "Barbz, stay in school. " +
                    "Don’t you ever be lazy—don’t you ever complain about hard work. Work hard, it pays off. Don’t let " +
                    "anyone tell you that you can’t do something. You wanna be a doctor, a lawyer, an engineer," +
                    " an artist, whatever it is—put in the work, study hard, and don’t give up. I love you, I believe in " +
                    "you, and I want to see all of you winning. Stay focused and stay in school!")
    );


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

    public void showInspiration() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(11);
        System.out.println(INSPIRATIONAL_QUOTES.get(randomNumber));
    }
}
