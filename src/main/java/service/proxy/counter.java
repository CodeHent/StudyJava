package service.proxy;

public class counter implements liquor {

    liquor liquor;

    public counter(service.proxy.liquor liquor) {
        this.liquor = liquor;
    }

    public void taste() {
        System.out.println("counter taste");
        liquor.taste();
    }
}
