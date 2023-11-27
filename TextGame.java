import java.util.Scanner;

public class TextGame {
    private String playerName = "";
    private final Scanner scanner = new Scanner(System.in);

    public void launchGame() {
        String gameProgress = "0";
        int input;

        while (true) {
            switch (gameProgress) {
                case "0":
                    System.out.println("Press ENTER to START.");
                    scanner.nextLine();

                    System.out.println("亗 THE KING'S SECRET MESSAGE 亗");
                    System.out.println("""
                            You are someone who enjoys exploring the secrets and riches of the tombs
                            of long forgotten people who we don't care about today.
                            
                            Basically, what you do is rob dead people's graves. You are what most people
                            would call a thief. But you prefer "archeologist."
                            
                            What was your name again?""");

                    System.out.print("> ");
                    playerName = scanner.nextLine();
                    System.out.println();
                    gameProgress = "0.5";
                    break;

                case "0.5":
                    System.out.println("Ah, right, your name was " + playerName + ".");
                    System.out.println("""
                            
                            It was revealed in the network that one tomb in particular contains the last
                            three words of a long forgotten king. The first five individuals to learn of
                            the phrase are given promises of fame and fortune.
                            
                            Now you stand before the entrance of that very tomb, gaping at the sky like
                            an open mouth. Well, you've always walked through danger. With your wits
                            about you and flashlight in hand, what do you do?
                            
                            1. Enter the tomb.""");

                    getIntInput(1);
                    gameProgress = "1";
                    break;

                case "1":
                    System.out.println("""
                            You set off. The entrance leads to a long staircase down to the earth. The
                            walls are rough but solid like clay.
                            
                            Eventually, you reach the end of the staircase and find yourself facing
                            a fork in the hallway. To the left, you occasionally hear some sort of metal
                            dragging across the ground. To the right, there is silence.
                            
                            1. Go left.
                            2. Go right.""");

                    input = getIntInput(2);
                    gameProgress = switch (input) {
                        case 1 -> "2.1";
                        case 2 -> "2.2";
                        default -> gameProgress;
                    };
                    break;

                case "2.1":
                    System.out.println("""
                            You walk for a bit and find a long hallway with massive axes swinging from
                            the ceiling. Well, you need to get through one way or another.
                            
                            1. Jump across them.
                            2. Roll and dive.""");

                    input = getIntInput(2);
                    switch (input) {
                        case 1:
                            System.out.println("""
                                    On your first jump, both axes come down and your life literally
                                    flashes before your eyes.
                                    
                                                            ☠☠☠
                                    It seems you have died. Press enter to try again.""");
                            scanner.nextLine();
                            gameProgress = "0.5";
                            break;

                        case 2:
                            System.out.println("""
                                    You roll on time before the first pair of axes swing down and stop
                                    right before the second pair comes down a few inches from your nose.
                                    
                                    You do duck and roll three more times and dive on the last one. You
                                    made it!
                                    
                                    (Press enter to continue.)""");
                            scanner.nextLine();
                            gameProgress = "3";
                            break;
                    }
                    break;

                case "2.2":
                    System.out.println("""
                            You walk for about half an hour uneventfully, and you think you finally
                            see the end of this hallway. A few more minutes and then nothing, it's
                            a dead end.
                            
                            1. Go back.""");
                    getIntInput(1);
                    gameProgress = "1";
                    break;

                case "3":
                    System.out.println("""
                            With the axes swinging behind you, you lead on to the next.
                            
                            There's another hallway before you, this one unusually long.""");
            }
        }
    }

    private int getIntInput(int max) {
        int userInput;

        while (true) {
            try {
                System.out.print("> ");
                userInput = scanner.nextInt();
                scanner.nextLine();

                if (userInput >= 1 && userInput <= max) break;
            } catch (Error ignored) {
            }
        }

        System.out.println();

        return userInput;
    }
}
