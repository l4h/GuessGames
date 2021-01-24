import java.util.Random;
import java.util.Scanner;

public class Guesser {
    static int rEnd = 10;
    static int random = new Random().nextInt(10);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int playAgain;

        guessTheWord();
        do {
            PlayNumber();
            System.out.println("would you like to play again?(1 - yes/ 0 - no):");

            if (sc.hasNextInt()) {
                playAgain = sc.nextInt();
            } else playAgain = 0;

        } while (playAgain == 1);


    }

    //homework 1 (guess the number)
    private static void PlayNumber() {
        int counter = 0;
        int attemps = 3;
        int userNumber;
        random = new Random().nextInt(10);

        System.out.println("You have " + attemps + " attemps\nEnter number from 0 to 9(99 for exit):");
        while (counter < attemps) {
            System.out.println();
            if (sc.hasNextInt()) {
                userNumber = sc.nextInt();
                if (inRange(rEnd, userNumber)) {

                    if (userNumber == random) {
                        System.out.println("Congratulations! You win!\n");
                        break;
                    } else if (userNumber > random) {
                        System.out.println("Hidden number is smaller");
                    } else {
                        System.out.println("hidden number is greater");
                    }
                    counter++;
                    System.out.println(attemps - counter + " attemps left");
                } else if (userNumber == 99) {
                    System.exit(0);
                } else {
                    System.out.println("Pleeeeeese, enter number in range 0 to 9!\n");
                    sc.nextLine();
                }
            } else {
                sc.nextLine();
            }
        }
    }


    private static boolean inRange(int endRange, int userNumber) {
        if (userNumber < endRange) {
            return true;
        }
        return false;
    }

    //Homework 2 (guess the word)
    private static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int indexConceivedWord = new Random().nextInt(words.length);
        String guessedWord;
        System.out.println("Enter word that was conceived:");
        while (true) {
            guessedWord = sc.nextLine();
            guessedWord = guessedWord.toLowerCase();
            if (guessedWord.equals(words[indexConceivedWord]) || guessedWord.equals("exit")) {
                System.out.println("My congratulations! You guessed the word!");
                break;
            } else {
                printHelp(words[indexConceivedWord], guessedWord);
                System.out.println("try again:");
            }
        }

    }

    private static void printHelp(String conceivedWord, String userWord) {
        int length;
        boolean sameChar = false;
        String helpString = "";

        if (conceivedWord.length() < userWord.length()) {
            length = conceivedWord.length();
        } else {
            length = userWord.length();
        }
        for (int i = 0; i < length; i++) {
            if (conceivedWord.charAt(i) == userWord.charAt(i)) {
                sameChar = true;
                helpString += conceivedWord.charAt(i);

            } else {
                helpString += "#";
            }
        }

        if (sameChar) {
            int remain = 15 - helpString.length();
            for (int i = 0; i < remain; i++) {
                helpString += "#";
            }
            System.out.println(helpString);
        }

    }


}
