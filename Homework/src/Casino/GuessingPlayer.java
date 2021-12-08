package Casino;

public class GuessingPlayer extends Casino{
    public GuessingPlayer(){
        super();
        System.out.println("Welcome, Esteemed Guest");
    }
    public GuessingPlayer(double money, String name){
        super(name, money);
        if(money>100){
            System.out.println("This is a low stakes game, no more than $100 in hand");
            setMoney(100);
        }
    }
    private int RandomNum(){
        return (int)(Math.random()*10-1);
    }
    public void Helper(){
        System.out.println("Here's how the prize system works");
        System.out.println("A random number from 1 to 10 will be generated");
        System.out.println("And depending on how close your guess was, you will receive a prize!");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                                                                      |");
        System.out.println("|        -------------        -------------        -------------       |");
        System.out.println("|       |  Number - 1 |      |  The Number |      |  Number + 1 |      |");
        System.out.println("|        -------------        -------------        -------------       |");
        System.out.println("|       | x1 Your Bet |      | x2 Your Bet |      | x1 Your Bet |      |");
        System.out.println("|        -------------        -------------        -------------       |");
        System.out.println("|                                                                      |");
        System.out.println("|                     Any Other Number: No Prize :(                    |");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Happy Gambling!");
    }
    public void setMoney(double money) {
        if (money > 100) {
            System.out.println("This is a low stakes game, no more than $100 in hand");
            setMoney(100);
        } else super.setMoney(money);
    }
    public void Play(int guess){
        if(getBet()>getMoney()){
            System.out.println("Your bet amount exceeds your balance!");
            System.out.println("Please change bet amount or get richer!");
            return;
        }
        int num = RandomNum();
        if(guess==num){
            setMoney(getMoney()+getBet()*2);
            System.out.println("Ding Ding Ding! Correct!\nYou have won"+getBet()*2+" dollars.");
        }
        else if(guess+1==num||guess-1==num){
            setMoney(getMoney()+getBet());
            System.out.println("Almost there! The number was "+num+".\nYou have won "+getBet()+" dollars.");
        }else if(guess > 10 || guess < 1){
            System.out.println("Cannot guess out of bounds! Money returned and game reset");
        }
        else{
            setMoney(getMoney()-getBet());
            System.out.println("Too Bad!. The number was "+num+". \nYou have lost "+getBet()+" dollars.");
        }
    }
}
