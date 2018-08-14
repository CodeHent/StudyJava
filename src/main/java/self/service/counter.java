package self.service;

public class counter implements liquor {

    liquor liquor;

    public counter(self.service.liquor liquor) {
        this.liquor = liquor;
    }

    public void taste() {
        System.out.println("counter taste");
        liquor.taste();
    }
}
