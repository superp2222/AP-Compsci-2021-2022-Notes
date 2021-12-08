package Casino;

public class Casino {
    double money;
    String name;
    double bet = 0;

    public Casino(){
        name = "Guest";
        money = 100;
    }
    public Casino(String name, double money){
        this.money = money;
        this.name = name;
        System.out.println("Welcome back, "+name);
    }

    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBet() {
        return bet;
    }
    public void betAMT(double bet) {
        if(money - bet < 0) System.out.println("Cannot withdraw more than you own!");
        else this.bet = bet;
    }
}
