import java.util.*;

public class Lab1d {

    public static void main(String[] args) {

        String[] msgs = {"Wrong! Try again.", "<Insert Snarky Message>", 
        "Absolutely not.", "Ha. Stupid.", "Inconceivable.", "Are you even trying?",
        "I am disgusted by you.", "I'll tell it to you at this point.", "Just quit now.",
        "You really can't mess this one up ... wouldn't put it past you."};

        Scanner scanner = new Scanner(System.in);

        Random rand = new Random(System.currentTimeMillis());
        int num = rand.nextInt(11);

        System.out.print("Guess a number between 1 and 10: ");
        int guess = scanner.nextInt();
        int count = 1;
        while(guess != num) {
            System.out.print(msgs[(count - 1) % 10] + " Guess again: ");
            guess = scanner.nextInt();
            count++;
        }
        System.out.println("Right after " + count + " guesses!");
    }
}