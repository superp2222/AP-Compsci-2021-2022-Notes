import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a number");
        int first = scan.nextInt();
        System.out.println("Choose a second number");
        int second = scan.nextInt();
        if (first > second){
            for(int i = second; i<=first;i++){
                System.out.println(i);
            }
        }else if(first == second){
            System.out.println("Nothing In Between");
        } else{
            for(int i = first;i <=second;i++){
                System.out.println(i);
            }
        }
    }
}
