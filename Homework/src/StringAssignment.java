import java.util.Scanner;

    public class StringAssignment {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Please enter a word: ");
            String word = scan.next();
            String original = word;
            System.out.print("Please enter a letter: ");
            String letter = scan.next();
            for(int i=0;i<word.length();i++){
                if(word.substring(i,i+1).equals(letter)){
                    word = word.substring(0,i)+word.substring(i+1);
                }
            }
            if(word == original)System.out.println("No instances of the letter found");
            else System.out.println("Replacement complete, new word: "+word);
        }
    }
