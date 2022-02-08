package ArrayLists;

public class GradCookieOrder {
    private String name;
    private int orders;

    public GradCookieOrder(String n, int o){
        name = n;
        orders = o;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOrders() {
        return orders;
    }
    public void setOrders(int orders) {
        this.orders = orders;
    }
}
