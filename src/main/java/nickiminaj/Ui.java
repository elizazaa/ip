package nickiminaj;

import nickiminaj.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Ui {
    private Scanner scanner;

    private static final List<String> INSPIRATIONAL_QUOTES = new ArrayList<>(List.of(
            "You don't have to feel the need to put somebody down to make yourself feel better.",
            "I came to win, to fight, to conquer, to thrive.",
            "Your victory is right around the corner. Never give up.",
            "People will love you and support you when it’s beneficial.",
            "True confidence leaves no room for jealousy. When you know you are great, you have no need to hate.",
            "When you’re a girl, you have to be everything, You have to be dope at what you do but you have to be super sweet.",
            "I stand for girls wanting to be sexy and not apologizing for it.",
            "You wanna know what scares people? Success.",
            "I do what I want. I’m unapologetic about it.",
            "You should never feel afraid to become a piece of art. It’s exhilarating.",
            "If you don’t take control over your own attitude, someone else will.",
            "Call it a curse, or just call me blessed. If you can’t handle my worst, you ain’t getting my best.",
            "Refuse to lose, refuse to be defeated, refuse to have regrets.",
            "Life is a movie, but there will never be a sequel.",
            "Stay in school. Don’t ever be lazy, don’t complain about anything. Work hard for what you want.",
            "No matter what happens, in life, be good to people. Being good to people is a wonderful legacy to leave behind.",
            "There’s nothing more beautiful than a smile that has struggled through tears.",
            "Mind over matter. I don’t mind, and you don’t matter.",
            "Sometimes you don’t realize how far you’ve gotten until you look around at the people who are still trailing behind you.",
            "Don’t stay watching happiness, make it.",
            "You are your best thing.",
            "I believe that life is a prize, but to live doesn’t mean you’re alive.",
            "I am not a word, I am not a line, I am not a girl that can ever be defined.",
            "Shout out to my haters, sorry that you couldn’t phase me.",
            "Never let success get to your head, and never let failure get to your heart.",
            "Cherish these nights, cherish these people. Life is a movie, but there will never be a sequel.",
            "They can imitate you, but they can’t duplicate you.",
            "Your reputation will never be real unless you make it real.",
            "All things go, all things change.",
            "Success comes when people act like they didn’t hear you."
    ));

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
        int randomNumber = rand.nextInt(10);
        System.out.println(INSPIRATIONAL_QUOTES.get(randomNumber));
    }
}
