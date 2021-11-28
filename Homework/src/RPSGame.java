import java.sql.SQLOutput;
import java.util.Scanner;

public class RPSGame {
    public static void main(String[] args) {
        String username;
        int gameRounds = 0;
        String compFinal = "";
        String playerFinal = "";
        int playerChoice;
        int compChoice;
        int playerScore = 0;
        int compScore = 0;
        int ties = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Rock Paper Scissors, please enter a username to get started");
        username = scan.next();
        System.out.print("Please enter the rounds you would like to play: ");
        gameRounds = scan.nextInt();

        for(int i = 1; i<=gameRounds;i++) {
            System.out.println("\nCurrent Standings: ");
            System.out.println(username + ": " + playerScore + "\tComputer: " + compScore);
            System.out.println("Current Round: "+i+" of "+gameRounds);
            System.out.println("\n Please enter 1 for Rock, 2 for Paper, 3 for Scissors");
            playerChoice = scan.nextInt();
            int rand = (int) (Math.random() * (3 - 1 + 1) + 1);
            if(rand == 1){
                compFinal = "Rock";
                if(playerChoice == 1){
                    playerFinal = "Rock";
                    System.out.println("Draw!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    ties++;
                }else if(playerChoice == 2){
                    playerFinal = "Paper";
                    System.out.println("Win!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    playerScore++;

                }else if(playerChoice == 3){
                    playerFinal = "Scissors";
                    System.out.println("Lose!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    compScore++;
                }else{
                    System.out.println("Invalid Choice, Retry?");
                    i--;
                }
            }else if(rand == 2){
                compFinal = "Paper";
                if(playerChoice == 1){
                    playerFinal = "Rock";
                    System.out.println("Lose!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    compScore++;

                }else if(playerChoice == 2){
                    playerFinal = "Paper";
                    System.out.println("Draw!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    ties++;
                }else if(playerChoice == 3){
                    playerFinal = "Scissors";
                    System.out.println("Win!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    playerScore++;
                }else{
                    System.out.println("Invalid Choice, Retry?");
                    i--;
                }

            }else{
                if(playerChoice == 1){

                    System.out.println("Win!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    playerScore++;
                }else if(playerChoice == 2){
                    playerFinal = "Paper";
                    System.out.println("Lose!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    compScore++;

                }else if(playerChoice == 3){
                    playerFinal = "Scissors";
                    playerFinal = "Rock";
                    System.out.println("Draw!");
                    System.out.println(username + ": " + playerFinal + "\tComputer: " + compFinal);
                    ties++;
                }else{
                    System.out.println("Invalid Choice, Retry?");
                    i--;
                }

            }

        }
        System.out.println();
        if(playerScore==compScore){
            System.out.println("Draw!");
            System.out.println("Wins: " + playerScore + "\tLosses: " + compScore + "\tTies: " + ties);
        }else if (playerScore>compScore) {
            System.out.println(username + " is the winner!");
            System.out.println("Wins: " + playerScore + "\tLosses: " + compScore + "\tTies: " + ties);
        }else{
            System.out.println("Computer is the winner!");
            System.out.println("Wins: " + playerScore + "\tLosses: " + compScore + "\tTies: " + ties);
        }




    }
}
