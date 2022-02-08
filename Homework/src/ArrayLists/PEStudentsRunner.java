package ArrayLists;

import java.util.ArrayList;

public class PEStudentsRunner {
    public static void main(String[] args) {
        PEStudents ian = new PEStudents("Ian", 215);
        PEStudents desmond = new PEStudents("Desmond", 100);
        PEStudents connor = new PEStudents("Connor", 185);
        PEStudents jack = new PEStudents("Jack", 155);
        PEStudents weakling = new PEStudents("EdG", 0);
        ArrayList<PEStudents> pelist = new ArrayList<PEStudents>();
        pelist.add(ian);
        pelist.add(desmond);
        pelist.add(connor);
        pelist.add(jack);
        pelist.add(weakling);
        int sum = 0;
        for(int i = 0;i<pelist.size();i++){
            sum+=pelist.get(i).getBenchpress();
        }
        double avg = (double) sum / pelist.size();
        System.out.println("Average is "+avg);
        String search = "Ian";
        boolean found = false;
        int index = 0;
        for(int i = 0; i>pelist.size();i++){
            if(search.equals(pelist.get(i).getName())){
                found = true;
                index = i;
            }
        }
        for(int i = 0; i< pelist.size();i++){
            pelist.get(i).setBenchpress(pelist.get(i).getBenchpress()+5);
        }
        for(PEStudents thing : pelist){
            System.out.println(thing.getBenchpress());
        }
        
    }
}
