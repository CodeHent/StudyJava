package test.chapter5.assign17;


import static test.util.Out.print;

public class Dog {
    public static void main(String... args){
        Leg[] legs = new Leg[4];
        for (Leg leg:legs){
            print(leg);
        }
    }
}

class Leg{
    String name;
    public Leg(int i){
        this.name = "第"+i+"条腿";
        System.out.println("init leg"+ i);
    }
}