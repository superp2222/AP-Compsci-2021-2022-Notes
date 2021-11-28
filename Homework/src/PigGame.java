import java.util.Scanner;

public class PigGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;
        int playerOneSum = 0;
        int playerTwoSum = 0;
        int diceOne = 0;
        int diceTwo = 0;
        boolean overridePlayerTwo = false;
        boolean firstRound = false;
        int playerResponse = 0;
        while(playerOneSum <100 && playerTwoSum < 100) {
            diceOne = (int) (Math.random() * (6 - 1 + 1) + 1);
            diceTwo = (int) (Math.random() * (6 - 1 + 1) + 1);
            if(diceOne == 6 || diceTwo == 6) firstRound = true;
            else firstRound = false;
            while (firstRound) {
                diceOne = (int) (Math.random() * (6 - 1 + 1) + 1);
                diceTwo = (int) (Math.random() * (6 - 1 + 1) + 1);
                if(diceOne == 6 || diceTwo == 6) firstRound = true;
                else firstRound = false;
            }
            playerResponse = 0;
            playerOneSum += diceOne+diceTwo;
            System.out.println("------------");
            System.out.println("| Player 1 |");
            System.out.println("------------");
            System.out.println("Your Rolls Are: ");
            System.out.println(diceOne + " & " + diceTwo);
            System.out.println("Current sum: "+playerOneSum);
            if (playerOneSum < 100) {
                System.out.println("Do you wish to play again?\n Enter 1 for Yes and 2 for No");
                playerResponse = 0;
                while ((playerResponse != 1) && (playerResponse != 2)) {
                    playerResponse = scan.nextInt();
                    if (playerResponse == 1) playAgain = true;
                    else if (playerResponse == 2) playAgain = false;
                    else {
                        System.out.println("Invalid Choice, try again?");
                        playerResponse = scan.nextInt();
                    }
                }
            }
            playerResponse = 0;
            while(playAgain && (playerOneSum <100 && playerTwoSum < 100) ){
                diceOne = (int) (Math.random() * (6 - 1 + 1) + 1);
                diceTwo = (int) (Math.random() * (6 - 1 + 1) + 1);
                if(diceOne == 6 && diceTwo == 6){
                    System.out.println("Double Sixes! Sum Cleared and Turn Ends!");
                    playerOneSum = 0;
                    playAgain = false;
                }else if(diceOne == 6 || diceTwo == 6){
                    System.out.println("A Six! No additions this round!\nTurn Ends!");
                    System.out.println("\nYour Rolls Are: ");
                    System.out.println(diceOne + " & " + diceTwo);
                    System.out.println("Current sum: "+playerOneSum);
                   playAgain = false;
                }else{
                    playerOneSum += diceOne + diceTwo;
                    System.out.println("\nYour Rolls Are: ");
                    System.out.println(diceOne + " & " + diceTwo);
                    System.out.println("Current sum: "+playerOneSum);
                    if (playerOneSum < 100) {
                        System.out.println("Do you wish to play again?\n Enter 1 for Yes and 2 for No");
                        playerResponse = 0;
                        while ((playerResponse != 1) && (playerResponse != 2)) {
                            playerResponse = scan.nextInt();
                            if (playerResponse == 1) playAgain = true;
                            else if (playerResponse == 2) playAgain = false;
                            else {
                                System.out.println("Invalid Choice, try again?");
                                playerResponse = scan.nextInt();
                            }
                        }
                    }
                }
            }
            if(playerOneSum >=100) overridePlayerTwo = true;
            //Player 2 portion
            if(!overridePlayerTwo) {
                playerResponse = 0;
                diceOne = (int) (Math.random() * (6 - 1 + 1) + 1);
                diceTwo = (int) (Math.random() * (6 - 1 + 1) + 1);
                if (diceOne == 6 || diceTwo == 6) firstRound = true;
                else firstRound = false;
                while (firstRound) {
                    diceOne = (int) (Math.random() * (6 - 1 + 1) + 1);
                    diceTwo = (int) (Math.random() * (6 - 1 + 1) + 1);
                    if (diceOne == 6 || diceTwo == 6) firstRound = true;
                    else firstRound = false;
                }
                playerTwoSum += diceOne + diceTwo;
                System.out.println("------------");
                System.out.println("| Player 2 |");
                System.out.println("------------");
                System.out.println("Your Rolls Are: ");
                System.out.println(diceOne + " & " + diceTwo);
                System.out.println("Current sum: " + playerTwoSum);
                if (playerTwoSum < 100) {
                    System.out.println("Do you wish to play again?\n Enter 1 for Yes and 2 for No");
                    playerResponse = 0;
                    while ((playerResponse != 1) && (playerResponse != 2)) {
                        playerResponse = scan.nextInt();
                        if (playerResponse == 1) playAgain = true;
                        else if (playerResponse == 2) playAgain = false;
                        else {
                            System.out.println("Invalid Choice, try again?");
                            playerResponse = scan.nextInt();
                        }
                    }
                }
                playerResponse = 0;
                while (playAgain && (playerOneSum < 100 && playerTwoSum < 100)) {
                    diceOne = (int) (Math.random() * (6 - 1 + 1) + 1);
                    diceTwo = (int) (Math.random() * (6 - 1 + 1) + 1);
                    if (diceOne == 6 && diceTwo == 6) {
                        System.out.println("Double Sixes! Sum Cleared and Turn Ends!");
                        playerTwoSum = 0;
                        playAgain = false;
                    } else if (diceOne == 6 || diceTwo == 6) {
                        System.out.println("A Six! No additions this round!\nTurn Ends!");
                        System.out.println("\nYour Rolls Are: ");
                        System.out.println(diceOne + " & " + diceTwo);
                        System.out.println("Current sum: " + playerTwoSum);
                        playAgain = false;
                    } else {
                        playerTwoSum += diceOne + diceTwo;
                        System.out.println("\nYour Rolls Are: ");
                        System.out.println(diceOne + " & " + diceTwo);
                        System.out.println("Current sum: " + playerTwoSum);
                        if (playerTwoSum < 100) {
                            System.out.println("Do you wish to play again?\n Enter 1 for Yes and 2 for No");
                            playerResponse = 0;
                            while ((playerResponse != 1) && (playerResponse != 2)) {
                                playerResponse = scan.nextInt();
                                if (playerResponse == 1) playAgain = true;
                                else if (playerResponse == 2) playAgain = false;
                                else {
                                    System.out.println("Invalid Choice, try again?");
                                    playerResponse = scan.nextInt();
                                }
                            }
                        }
                    }
                }
            }

        }
        if(playerOneSum >= 100) System.out.println("Player One Wins!");
        else System.out.println("Player Two wins!");
    }
}
