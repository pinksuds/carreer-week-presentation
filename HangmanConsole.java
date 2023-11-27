import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanConsole {
    private final String[] hangmanStates = new String[]{
            """
+------+
|      |
|      O
|
|
|
|""",
            """
+------+
|      |
|      O
|     /
|
|
|""",
            """
+------+
|      |
|      O
|     /|
|
|
|""",
            """
+------+
|      |
|      O
|     /|\\
|
|
|""",
            """
+------+
|      |
|      O
|     /|\\
|     /
|
|""",
            """
+------+
|      |
|      O
|     /|\\
|     / \\
|
|"""
    };

    private final String[] words = {
            "PROGRAMMING",
            "INFORMATION",
            "COMMUNICATION",
            "TECHNOLOGY",
            "INTELLIGENCE",
            "MATHEMATICS",
            "UNDERSTANDING",
            "APPLICATION",
            "DEVELOPMENT",
            "EXPERIENCE",
            "EXPLANATION",
            "INTERESTING",
            "ENVIRONMENT",
            "EFFICIENCY",
            "ORGANIZATION",
            "PROFESSIONAL",
            "UNIVERSITY",
            "DEMONSTRATION",
            "REVOLUTIONARY",
            "CONSIDERATION"
    };

    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        int gameLoop = 0;


        while (true) {
            switch (gameLoop) {
                case 0:
                    System.out.println("////////// HANGMAN CONSOLE //////////");
                    System.out.println("1. Start game.");
                    System.out.println("2. Exit.");
                    gameLoop = getIntInput();
                    break;

                case 1:
                    int lives = 5;
                    String wordToGuess = getRandomWord();
                    char[] wordArray = new char[wordToGuess.length()];
                    populateArray(wordArray);
                    boolean hasWon = false;

                    while (true) {
                        System.out.println("-------------------------------------");
                        System.out.println(hangmanStates[5 - lives]);
                        System.out.println("WORD: " + arrayToString(wordArray));
                        char guess = Character.toUpperCase(getCharInput());
                        boolean isCorrect = checkGuess(guess, wordToGuess, wordArray);

                        if (!isCorrect) {
                            lives--;
                        }

                        if (lives == 0) {
                            System.out.println("-------------------------------------");
                            System.out.println(hangmanStates[5 - lives]);
                            System.out.println("WORD: " + arrayToString(wordArray));
                            break;
                        }

                        if (checkIfWon(wordArray)) {
                            System.out.println("-------------------------------------");
                            System.out.println(hangmanStates[5 - lives]);
                            System.out.println("WORD: " + arrayToString(wordArray));
                            hasWon = true;
                            break;
                        }
                    }

                    if (hasWon) {
                        System.out.println("-------------------------------------");
                        System.out.println("You won亗! You're literally so good. :)");
                        System.out.println("The WORD was: " + wordToGuess);
                    } else {
                        System.out.println("-------------------------------------");
                        System.out.println("Awwwwwh snap! You lost. :(");
                        System.out.println("The WORD was: " + wordToGuess);
                    }

                    System.out.println();
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    gameLoop = 0;
                    break;

                case 2:
                    System.out.println("-------------------------------------");
                    System.out.println("Have a great day!");
                    System.exit(1);

                default:
                    gameLoop = 0;
                    break;
            }
        }
    }

    private int getIntInput() {
        int userInput;

        while (true) {
            try {
                System.out.print("> ");
                userInput = scanner.nextInt();
                scanner.nextLine();

                if (userInput == 1 || userInput == 2) break;
            } catch (Error ignored) {
            }
        }

        return userInput;
    }

    private char getCharInput() {
        char userInput;

        while (true) {
            try {
                System.out.print("Guess a letter: ");
                String input = scanner.nextLine();
                if (input.length() == 1) {
                    userInput = input.charAt(0);
                    break;
                }
            } catch (Error ignored) {
            }
        }
        return userInput;
    }

    private String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }

    private void populateArray(char[] array) {
        Arrays.fill(array, '_');
    }

    private String arrayToString(char[] array) {
        StringBuilder result = new StringBuilder();
        for (char c : array) {
            result.append(" ").append(c);
        }

        return result.toString();
    }

    private boolean checkGuess(char guess, String wordToGuess, char[] wordArray) {
        boolean isCorrect = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                wordArray[i] = guess;
                isCorrect = true;
            }
        }

        return isCorrect;
    }

    private boolean checkIfWon(char[] array) {
        boolean hasWon = true;

        for (char c : array) {
            if (c == '_') {
                hasWon = false;
                break;
            }
        }

        return hasWon;
    }
}