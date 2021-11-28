import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        //Wording of the question says "between" so i'm assuming 100 and 200 don't get printed
        int num = 100;
        while(num<=200){
            if(num%2 == 0 && num != 200 && num != 100) System.out.println(num);
            num++;
        }
    }
}
