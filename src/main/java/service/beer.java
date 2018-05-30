package service;

public class beer implements liquor {
    public void taste() {
        System.out.println(this.getClass().getName()+" taste well!");
    }
}
