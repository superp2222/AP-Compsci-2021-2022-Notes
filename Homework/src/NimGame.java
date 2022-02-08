import java.sql.SQLOutput;
import java.util.Scanner;

public class NimGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;
        int playerResponse = 0;
        boolean overridePlayerTwo = false;
        int selectBox = 0;
        int selectValue = 0;
        System.out.println("Welcome to Nim");
        System.out.println("Force the other player to remove the last stone");
        System.out.println("to win");
        int[] nim = {1,2,3,4,5};
        while(playAgain){
            //Player 1 Portion
            System.out.println("------------");
            System.out.println("| Player 1 |");
            System.out.println("------------");
            System.out.println();
            System.out.println("------------");
            System.out.println("| Box 1: "+nim[0] + " |");
            System.out.println("| Box 2: "+nim[1] + " |");
            System.out.println("| Box 3: "+nim[2] + " |");
            System.out.println("| Box 4: "+nim[3] + " |");
            System.out.println("| Box 5: "+nim[4] + " |");
            System.out.println("------------");
            System.out.println();
            System.out.println("Which box would you like to remove from?");
            selectBox = 0;
            while (((selectBox != 1) && (selectBox != 2) && (selectBox != 3) && (selectBox != 4) && (selectBox != 5)) || nim[selectBox-1] == 0) {
                selectBox  = scan.nextInt();
                if (((selectBox != 1) && (selectBox != 2) && (selectBox != 3) && (selectBox != 4) && (selectBox != 5)) || nim[selectBox-1] == 0) {
                    System.out.println("Invalid choice. Please re-enter.");
                    selectBox = scan.nextInt();
                }
            }
            selectBox--;
            System.out.println("How much would you like to remove from Box "+(selectBox+1)+"?");
            selectValue = 0;
            while (nim[selectBox] - selectValue < 0 || selectValue == 0) {
                selectValue  = scan.nextInt();
                if (nim[selectBox] - selectValue < 0 || selectValue == 0) {
                    System.out.println("Invalid choice. Please re-enter.");
                    selectValue = scan.nextInt();
                }
            }
            nim[selectBox] -= selectValue;
            if(nim[0] == 0 && nim[1] == 0 && nim[2] == 0 && nim[3] == 0 && nim[4] == 0 ){
                System.out.println("--------------");
                System.out.println("Player 2 Wins!");
                System.out.println("--------------");
                playAgain = false;
                overridePlayerTwo = true;
            }
            if(!overridePlayerTwo){
                System.out.println("------------");
                System.out.println("| Player 2 |");
                System.out.println("------------");
                System.out.println();
                System.out.println("------------");
                System.out.println("| Box 1: "+nim[0] + " |");
                System.out.println("| Box 2: "+nim[1] + " |");
                System.out.println("| Box 3: "+nim[2] + " |");
                System.out.println("| Box 4: "+nim[3] + " |");
                System.out.println("| Box 5: "+nim[4] + " |");
                System.out.println("------------");
                System.out.println();
                System.out.println("Which box would you like to remove from?");
                selectBox = 0;
                while (((selectBox != 1) && (selectBox != 2) && (selectBox != 3) && (selectBox != 4) && (selectBox != 5)) || nim[selectBox-1] == 0) {
                    selectBox  = scan.nextInt();
                    if (((selectBox != 1) && (selectBox != 2) && (selectBox != 3) && (selectBox != 4) && (selectBox != 5)) || nim[selectBox-1] == 0) {
                        System.out.println("Invalid choice. Please re-enter.");
                        selectBox = scan.nextInt();
                    }
                }
                selectBox--;
                System.out.println("How much would you like to remove from Box "+(selectBox+1)+"?");
                selectValue = 0;
                while (nim[selectBox] - selectValue < 0 || selectValue == 0) {
                    selectValue  = scan.nextInt();
                    if (nim[selectBox] - selectValue < 0 || selectValue == 0) {
                        System.out.println("Invalid choice. Please re-enter.");
                        selectValue = scan.nextInt();
                    }
                }
                nim[selectBox] -= selectValue;
                if(nim[0] == 0 && nim[1] == 0 && nim[2] == 0 && nim[3] == 0 && nim[4] == 0 ){
                    System.out.println("--------------");
                    System.out.println("Player 1 Wins!");
                    System.out.println("--------------");
                    playAgain = false;
                }
            }


        }
    }
}
