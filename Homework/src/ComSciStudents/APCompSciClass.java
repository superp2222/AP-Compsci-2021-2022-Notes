package ComSciStudents;

public class APCompSciClass {
    String name;
    boolean playsGamesinClass;
    double mark;
    public APCompSciClass(){
        System.out.println("No Name Entered");
    }
    public APCompSciClass(String name, boolean playsGamesinClass){
        this.name = name;
        this.playsGamesinClass = playsGamesinClass;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getPlaysGamesinClass() {
        return playsGamesinClass;
    }
    public void setPlaysGamesinClass(boolean playsGamesinClass) {
        this.playsGamesinClass = playsGamesinClass;
    }
    public double getMark() {
        return mark;
    }
    public void setMark(double mark) {
        this.mark = mark;
    }
    //other things
    public void badStudent(){
        if(playsGamesinClass) System.out.println("Mr. Lu: "+name+" is a bad student!");
        else System.out.println("Mr Lu: "+name+" is a student.");
    }
    public boolean forgiveStudent(){
        if(mark >= 99 && playsGamesinClass){
            System.out.println("Mr. Lu: Alright, "+name+ ", I forgive you.");
            return true;
        }
        else{
            System.out.println("Mr. Lu: "+name+"! What the ki are you doing?! Get back to work!");
            return false;
        }
    }
    public String randomFail(int studentNumber){
        if(studentNumber%2 == 1) return "Fail";
        else return "No Fail";
    }
    public void passStudent(){
        if(mark <50) setMark(50);
    }

    @Override
    public String toString() {
        return name;
    }
}
