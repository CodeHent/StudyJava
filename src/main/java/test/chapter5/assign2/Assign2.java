package test.chapter5.assign2;

import static test.util.Out.print;

public class Assign2 {
    public static void main(String[] args){
        Demo demo = new Demo("1");
        print(demo.a);
        print(demo.s);
        demo.f(10);
    }
}
class Demo {
   public String s = "hello world";
    String a ;
    public Demo(String a){
        this.a = a;
    }
    public void f(long c){

    }
}
