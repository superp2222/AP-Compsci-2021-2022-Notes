package CasinoPlayer;

public class CasinoPlayer {
    public double balance;
    public String name;
    double bet = 0;
    public double inHand = 0;
    public CasinoPlayer(){
        name = "Allen Who?";
        balance = 0.0;
    }
    public CasinoPlayer(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void deposit(double deposit){
        balance += deposit;
    }
    public void withdraw(double withdraw){
        checkBalance(withdraw);
    }


    public int randomGenerator(int high, int low){
        return (int)(Math.random()*(high-low+1)+low);
    }
    
    private void checkBet(int max){
        if(bet > balance) System.out.println("Bet exceeds balance!");
        if(bet > max) System.out.println("Bet over max value!");
        if(bet < 0) System.out.println("Cannot make negative bets!");
    }
    private void checkBalance(double withdraw){
        if(withdraw > balance){
            System.out.println("Withdrawal exceeds balance!");
        }else{
            balance -= withdraw;
        }
    }

}
