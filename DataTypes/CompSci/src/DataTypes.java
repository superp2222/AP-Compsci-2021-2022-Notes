public class DataTypes {
    public static void main(String[] args) {
        //Objects have multiple pieces of info
        //primitive data only has onepiece

        //objects are capitalized
        //primitive data aint

        //int double String
        //to declare variables, declare the type first
        //variable name has no spaces, symbols, and cant start with nums

        int adam = 1;
        adam = 2;
        System.out.println(adam);

        int justin = 3;

        adam = adam + justin;

        System.out.println(adam);

        //coolio operators
        //++ adds one
        //+= adds 10
        //-- subs one

        adam = 1;
        adam++;
        adam += 5;
        adam--;

        System.out.println(adam);

        //an int has a max value
        //Instead of memorizing java provides the following constants
        //Integer.MAX_VALUE;
        //Integer.MIN_VALUE;
        System.out.println(Integer.MAX_VALUE);

        //doubles are real nums
        //integers can be stored in doubles but not the other way
        //doubles can go into decimals
        double connor = 1.2345;
        connor = 5;
        connor = Math.PI;

        int i = 1;
        double d = 1.5;

        //error
        //i = d;

        /*casting allows doubles to become integers
        and doubles to be truncated
        1.99 truncated becomes 1
        use Math.round() to round numbers*/

        double josh = 5.9;
        System.out.println(Math.round(josh));
        int allen;
        allen = (int)josh;
        System.out.println(allen);
        //random num from 10 and 30
        //note: must cast multiplication, not just math.random

        int rand = (int)Math.random()*(21)+10;
        System.out.println(rand);

        double eden;
        eden = (double)22/7;
        System.out.println(eden);

        double max;
        max = (double) (4/3);
        System.out.println(max);
        //in this case the division happened first, then the conversion happened
        //however, if it was (double)(4.0/3), 4.0 is treated as a double and therefore the results
        //arent truncated

        //sometimes you want to create a variable that cant be changed

        //use keyword final to make a variable a constant
        //out of convention constants are capp'd
        final double GRAVITY = 9.8;

        //booleans are either true or false
        boolean michael = false;

        




    }
}
