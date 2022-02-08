package ArrayLists;

import java.util.ArrayList;

public class ArrayListsHW {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("cat");
        list.add("dog");
        list.add("birb");
        list.add("mouse");
        list.add("elephant");
        list.add(2, "fish");
        list.set(4,"pig"); //returns maus
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
