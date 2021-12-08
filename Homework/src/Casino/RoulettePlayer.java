package Casino;

public class RoulettePlayer extends GuessingPlayer{
    public RoulettePlayer(){
        super();
    }
    public RoulettePlayer(double money,String name){
        super(money,name);
    }
    private int RandomNum(){
        return (int)(Math.random()*39)+1;
    }
    public void Helper(){
        System.out.println("Welcome to Roulette!");
        System.out.println("If your guess is the same as the number, you win 5 times what you bet.");
        System.out.println("If your guess is in the same range as the number, you win 2 times what you bet.");
        System.out.println("(Ranges: 1-13, 14-26, 27-39)");
        System.out.println("If your guess and the number are both even/odd, you win the amount that you bet.");
        System.out.println("Otherwise, you lose 2 times the amount that you bet.");
    }
    public static void Probability(){
        System.out.println("Your Odds Are: ");
        System.out.println("----------------------");
        System.out.println("| Exact number: 1/39 |");
        System.out.println("| Same range: 1/3    |");
        System.out.println("| Even: 19/39        |");
        System.out.println("| Odd: 20/39         |");
        System.out.println("----------------------");
    }
    public void Play(int guess){
        if(getBet()*2>getMoney()){
            System.out.println("You need more money! Get richer lol");
            return;
        }
        int num = RandomNum();
        if(guess==num){
            setMoney(getMoney()+getBet()*5);
            System.out.println("WE HAVE A WINNER! You have won "+getBet()*5+" dollars.");
        }
        else if((guess>=1&&guess<=13&&num>=1&&num<=13)||(guess>=14&&guess<=26&&num>=14&&num<=26)||(guess>=27&&guess<=39&&num>=27&&num<=39)){
            setMoney(getMoney()+getBet()*3);
            System.out.println("In the Range! You have won "+getBet()*3+" dollars.");
            System.out.println("The number was "+num+".");
        }
        else if(guess%2==0&&num%2==0||guess%2==1&&num%2==1){
            setMoney(getMoney()+getBet());
            System.out.println("Same Parity! You have won "+getBet()+" dollars.");
            System.out.println("The number was "+num+".");
        } else if(guess > 39 || guess < 1){
            System.out.println("Guess out of bounds! Money returned and game reset");
        }
        else{
            setMoney(getMoney()-getBet()*2);
            System.out.println("Wrong Guess! You have lost "+getBet()*2+" dollars.");
            System.out.println("The number was "+num+".");
        }
    }
}
