package ArrayLists;

public class PEStudents {
    private String name;
    private int benchpress;

    public PEStudents(String n, int b){
        name = n;
        benchpress = b;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBenchpress() {
        return benchpress;
    }
    public void setBenchpress(int benchpress) {
        this.benchpress = benchpress;
    }
}
