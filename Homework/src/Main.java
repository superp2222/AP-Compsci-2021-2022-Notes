import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        int num;
        boolean easymode = false;
        int random = (int)(Math.random()*100+1);
        System.out.println("Welcome to Number Guesser\nEnter 1 for Easy Mode, Enter any other number for Regular");
        int ans = scan.nextInt();
        if(ans == 1){
            easymode = true;
            System.out.println("EasyMode Selected");
        }else System.out.println("Regular Mode Selected");

        System.out.println("Number Has been Generated, Please guess now");
        while(counter <=10){
            counter++;
            num = scan.nextInt();
            if(num == random){
                System.out.println("Congratulations! You Got it!");
                System.out.println("No. of Attempts: " + counter);
                break;
            }else if(num<random){
                System.out.println("Too Low, Try Again?");
                if(easymode == true)System.out.println("You were " +Math.abs(num-random)+ " away");
            }else{
                System.out.println("Too High, Try Again?");
                if(easymode == true)System.out.println("You were " +Math.abs(num-random)+ " away");
            }
        }
        if(counter > 10){
            System.out.println("Sorry, Out of Attempts");
        }
    }
}
