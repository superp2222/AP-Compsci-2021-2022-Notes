import java.util.Scanner;

public class NestedFors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Q1
        for(int i = 1; i<=10; i++){
            for(int j = 1; j<=10; j++){
                System.out.println(i + " / " + j + " = " +((double)i/(double)j));
            }
        }
        //Q2
        System.out.println("Enter lower bound");
        int num1 = 3;
        System.out.println("Enter upper bound");
        int num2 = 1000;
        for(int i = num1; i<=num2; i++){
            int sum = 0;
            for(int j = 1; j<i;j++){
                if(i%j==0){
                    sum+=j;
                }
            }
            if(sum == i){
                System.out.println("Perfect num found: "+i);
            }
        }
        //Q3
        for(int i = 1; i<=5; i++){
            for(int j = 1; j<=5; j++){
                System.out.print(j*i + " ");
            }
            System.out.println();
        }
        //Q4
        for(int i = 1; i<6;i++){
            for(int k=5; k>i; k--){
                System.out.print(".");

            }
            System.out.print(i);
            System.out.println();
        }
        System.out.println();
        //Q5
        System.out.println("Enter Upper Bound");
        int ubound = scan.nextInt();
        for(int i = 1; i<=ubound+1; i++){
            int sum = 0;
            for(int j = 1; j<i;j++){
                sum += j;

            }
            System.out.print(sum + " = ");
            for(int k = 1; k<i;k++){
                System.out.print(k + " + ");
            }
            System.out.print("0");
            System.out.println();
        }
        System.out.println();

        //Q6
        for(int i = 9; i>=0;i--){
            for(int j = 1; j<= 10-i;j++){
                System.out.print(10-j);
            }
            System.out.println();
        }
        System.out.println();

        //Random Practice

        for(int i = 0; i < 5; i++){
            for(int j = 5; j> 0+i; j--){
                System.out.print("*");
            }
            for(int k = -1; k<i;k++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
