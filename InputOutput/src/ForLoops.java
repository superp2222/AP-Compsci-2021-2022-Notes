import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {
        //next class - boolean quiz
        //next next class - guess my num
        //next week quiz - if/else

        //For Loops
        //for(start;end;increment)

        //Example 1
        for (int i = 1; i <= 10; i++) {
            System.out.println("Ed Wang is great. " + i);
            //i is actually declared as a variable so you can use it for stuff
        }

        //Example 2
        //The increment can be changed
        //The start and end can be changed

        //Print all odd nums
        for (int i = 1; i <= 99; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        //flip the order
        for (int i = 99; i >= 1; i -= 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        //Exercise 1
        //Write FizzBuzz
        //Multiple of 3, Fizz, Multiple of 5, Buzz
        //Print all other numbers
        System.out.println();

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz" + " ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz" + " ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz" + " ");
            } else {
                System.out.print(i + " ");
            }
            if (i % 20 == 0) {
                System.out.println();
            }


        }

        //Exercise 2
        //Ask user for a num
        //Print the sum of 1 to that number
        //eg user chooses 5 --> 1+2+3+4+5=15
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Please Choose a Number");
        int num = scan.nextInt();
        int x = 0;
        for (int i = 1; i <= num; i++) {
            x += i;
        }
        System.out.println(x);

        //Exercise 3
        //Given a num, calculate factorial
        //Ex: enter 5 out 120

        System.out.println("\nPlease choose a number to find factorial");
        int entry = scan.nextInt();
        int y = 1;
        for(int i = 1; i<=num; i++){
            y *=i;
        }
        System.out.println(y + "\n");

        //Exercise 4
        //The user enters an integer
        //Print whether the num is prime or not

        System.out.println("Please Choose a Number");
        int prime = scan.nextInt();
        boolean isPrime = true;
        for(int i = 2; i<=prime; i++){
            if(prime%i == 0 && i != prime){
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Is Prime");
        }else{
            System.out.println("Is Composite");
        }

    }
}
