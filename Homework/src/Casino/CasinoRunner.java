package Casino;

public class CasinoRunner {
    public static void main(String[] args) {
        GuessingPlayer person = new GuessingPlayer(100, "Alpha");
        person.betAMT(2000);
        person.Helper();
        person.betAMT(10);
        person.Play(5);
        person.Play(20);
        person.betAMT(20);
        person.Play(5);
        System.out.println(person.getMoney());

        RoulettePlayer parson = new RoulettePlayer(100, "Beta");
        parson.betAMT(10);
        parson.Helper();
        RoulettePlayer.Probability();
        parson.Play(22);
        parson.Play(-10);
        parson.Play(21);
        System.out.println(parson.getMoney());



    }
}
