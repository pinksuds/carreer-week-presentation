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
                            
                            Basically, you rob dead people's graves. You are what most people
                            call a thief, but you prefer "archeologist."
                            
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
                            the phrase and tell the king's living assistant are given promises of a
                            notepad and a pen (it also serves as a phone stand btw).
                            
                            Now you stand before the entrance of that very tomb, gaping at the sky like
                            an open maw. Well, you've always walked towards danger. With your wits
                            about you and flashlight in hand, what would you do?
                            
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
                                    It seems you died. Press enter to try again.""");
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
                            
                            There's another hallway before you, this one unusually long. A gust of
                            wind blows out as it stretches out into the darkness.
                            
                            1. Go through it cautiously.
                            2. I'm running out of time, go through it fast.""");

                    input = getIntInput(2);
                    switch (input) {
                        case 1:
                            System.out.println("""
                                    You navigate through the hallway slowly, minding where you
                                    touched the walls and stepped on the floor.
                                    
                                    Right before you take a step, you notice that there's one tile
                                    on the floor that doesn't appear to have been worn down by time
                                    like the others around it. You step over it and smile to yourself,
                                    your patience paid off.
                                    
                                    (Press enter to continue.)""");
                            scanner.nextLine();
                            gameProgress = "4";
                            break;

                        case 2:
                            System.out.println("""
                                    You start sprinting down the hallway, the gusts of wind blowing
                                    through your hair. You feel alive, free, and then you step on
                                    something and it grinds deeper into the floor.
                                    
                                    You look down for a moment when something whistles past your
                                    ear. You look ahead just in time to see a split second image
                                    of the tip of an arrow to your head.
                                    
                                                        ☠☠☠
                                    It seems you died. Press enter to try again.""");
                            scanner.nextLine();
                            gameProgress = "0.5";
                            break;
                    }
                    break;

                case "4":
                    System.out.println("""
                            Eventually, you emerge out of the hallway into a wide chamber, to which it
                            branches out into two pathways again. At this point, you feel like you
                            are almost there.
                            
                            Wind blows from the first path, while you could hear some scuttling noises
                            from the second.
                            
                            1. Take the first path.
                            2. Go check out the scuttling noises.""");

                    input = getIntInput(2);
                    gameProgress = switch (input) {
                        case 1 -> "4.1";
                        case 2 -> "4.2";
                        default -> gameProgress;
                    };
                    break;

                case "4.1":
                    System.out.println("""
                            You walk normally along the first path, looking out for traps the same way
                            you did as the previous hallway. A few meters ahead, you notice a depression
                            on the floor. You get closer and realize its a series of spikes that line
                            up the floor.
                            
                            1. Roll and dive!
                            2. Jump over.""");

                    input = getIntInput(2);
                    switch (input) {
                        case 1:
                            System.out.println("""
                                    You put your head on the ground, and kick as you roll over and fall.
                                    What were you thinking?
                                    
                                                        ☠☠☠
                                    It seems you died. Press enter to try again.""");
                            scanner.nextLine();
                            gameProgress = "0.5";
                            break;

                        case 2:
                            System.out.println("""
                                    You walk a few paces back.
                                    
                                    With a few breaths to hype yourself up, you sprint and leap at the
                                    last second.
                                    
                                    You land on the other side and take a roll to complete the landing.
                                    You put both hands in the air in celebration.
                                    
                                    You made it!
                                    
                                    (Press enter to continue.)""");
                            scanner.nextLine();
                            gameProgress = "5";
                            break;
                    }
                    break;

                case "4.2":
                    System.out.println("""
                            The scuttling noises get louder.
                            
                            A few moments later, you reach a room at the end of the path. To your horror,
                            you realize it is filled with scorpions everywhere.
                            
                            You can see a dark path at the other end.
                            
                            1. Nope. Not a chance, I'll go back.
                            2. I need to get to the other end.""");

                    input = getIntInput(2);
                    switch (input) {
                        case 1:
                            System.out.println("""
                                    Smart. You take the wise choice to walk back
                                    
                                    (Press enter to continue.)""");
                            scanner.nextLine();
                            gameProgress = "4";
                            break;

                        case 2:
                            System.out.println("""
                                    You feel compelled. You take you first step into the room - right into
                                    one of the scorpions and you feel a sting on your ankles before
                                    everything goes dark.
                                    
                                                        ☠☠☠
                                    It seems you died. Press enter to try again.""");
                            scanner.nextLine();
                            gameProgress = "0.5";
                            break;
                    }
                    break;

                case "5":
                    System.out.println("""
                            You can see a light at the end of path, and you can feel your anticipation
                            rising.
                            
                            The light gets brighter as you get closer, until you step out into it and
                            the whole chamber gets revealed.
                            
                            There is nothing in it, except a pedestal in the center, and a single roll
                            of scroll floats atop it.
                            
                            Without any more preamble, you walk over it and place both hands on the
                            scroll.
                            
                            (Press ENTER to open it.""");
                    scanner.nextLine();
                    gameProgress = "6";
                    break;

                case "6":
                    System.out.println("""
                            On the scroll, it says:
                            
                            "Programming is Gangster."
                            
                            You found the secret phrase! Quick, make your way back to the king's
                            assistant to claim your reward.
                            
                            Good luck!
                            
                            (Press ENTER to exit.)""");
                    scanner.nextLine();
                    System.exit(1);
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
