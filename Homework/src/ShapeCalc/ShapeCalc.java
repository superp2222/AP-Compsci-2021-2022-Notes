package ShapeCalc;

//Create a class called shapecalc
public class ShapeCalc {
    //What is a static variable? Give an example when it would be used
        /*A static variable is a variable of the class and won't be associated with the object
        So no matter what the object does, that variable will remain constant unless directly altered within the class
        In other words, static means that there arent multiple instances of it created, but one main instance
        everything pulls from*/
    //Example:
    //In a standard PacMan game, there are 4 ghosts, every time a ghost is eaten by pacman, it will
    //return to the center box for a bit before exiting
    //It wouldnt make sense for each ghost to have an individual integer
    //so you have a static int GhostCount that counts how many ghosts are on the field


    //What is a static method? Give an example when it would be used.
    /*If youre creating a class that has instances of that class (like a bank account or a game player)
     * You would use static methods to perform actions that dont rely on the instance of that class.
     * Basically, you wouldn't require it to be linked to an instance of that class and it is free
     * to perform what you need */

    //What does public static void main mean?
    /*The PSVM method signals to the Java Virtual Machine where to start running the program
     * If you break it apart into its words
     * public means it can be accessed anywhere
     * static means it is independent of all instances
     * void means it doesnt have to return anything
     * and main tells the JVM where to start running. */
    //Here's the rest of the stuff

    //Create a static variable called numTimesUsed.
    public static int numTimesUsed = 0;
    String shapeName;
    //Create 2 constructors, both increment NTU by one but one takes a parameter name of shape
    public ShapeCalc(){
        numTimesUsed++;
    }
    public ShapeCalc(String shapeName){
        numTimesUsed++;
        shapeName = this.shapeName;
    }

    //A static method called circleInfo which takes one parameter and prints the circumference and area of the circle
    public static double circleInfo(double radius){
        return 23;
    }
    //A static method called rectangleInfo which accepts 2 parameters and prints perimeter and area


    @Override
    public String toString() {
        return shapeName;
    }
}
