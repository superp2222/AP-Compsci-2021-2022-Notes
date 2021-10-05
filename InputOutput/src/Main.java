import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Memorizing input code is NOT necessary
        /* But knowing the concept of input IS necessary*/

       /* int num;
        System.out.println("Enter an integer: ");
        */ Scanner scan = new Scanner(System.in);/*
        num = scan.nextInt();
        System.out.println("You entered: "+num); */

        //for doubles use scan.nextDouble()
        //scan.nextLine() for Strings

        //What could be on the AP or Lu's quizzes
        //num = //input from user
        //assume user enters an integer, num

        //exercise
        //ask the user to enter 3 diff integers
        //print out largest
        int firstnum;
        int secondnum;
        int thirdnum;
        System.out.println("Please Enter first integer");
        firstnum = scan.nextInt();
        System.out.println("Please Enter next integer");
        secondnum = scan.nextInt();
        System.out.println("Please Enter last integer");
        thirdnum = scan.nextInt();
        if(firstnum > secondnum && firstnum > thirdnum){
            System.out.println("Biggest Num: " + firstnum);
        }else if(secondnum > thirdnum){
            System.out.println("Biggest Num: " + secondnum);
        }else{
            System.out.println("Biggest Num: " + thirdnum);
        }

        //exercise 2
        //Generate a random num but don't tell the user
        //ask user to guess
        //tell use how far away

        int realnum = (int) (Math.random()*(100-1+1));
        int guessednum;
        System.out.println("Guess a num between 1 and 100");
        guessednum = scan.nextInt();
        if(guessednum == realnum) System.out.println("Correct");
        System.out.println("You were " + Math.abs(guessednum-realnum) + " away from the real num");
        System.out.println("Real num was: "+ realnum);

        //HW
        //Paper Worksheet
        //make a programmu




    }
}
