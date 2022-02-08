package ArrayLists;

import java.util.ArrayList;

public class GradCookieRunner {
    public static void main(String[] args) {
        ArrayList<GradCookieOrder> list = new ArrayList<GradCookieOrder>();
        GradCookieOrder Vincent = new GradCookieOrder("Vincent", 69);
        GradCookieOrder Rafeeq = new GradCookieOrder("Rafeeq", 420);
        GradCookieOrder Ehsian = new GradCookieOrder("Ben", 3);
        GradCookieOrder Billsboard = new GradCookieOrder("Bill", 10);
        GradCookieOrder Noobie56 = new GradCookieOrder("Aaron", 99);
        list.add(Vincent);
        list.add(Rafeeq);
        list.add(Ehsian);
        list.add(Billsboard);
        list.add(Noobie56);
        int checker = Integer.MIN_VALUE;
        for(GradCookieOrder cookies : list){
            if(cookies.getOrders() > checker) checker = cookies.getOrders();
        }
        System.out.println("Most Orders: "+checker);
        //Removing all ppl with less than 100 orders
        for(int i = list.size()-1;i>=0;i--){
            if(list.get(i).getOrders() < 100) list.remove(i);
        }
        for(GradCookieOrder cookies : list) System.out.println(cookies.getName());
    }
}
