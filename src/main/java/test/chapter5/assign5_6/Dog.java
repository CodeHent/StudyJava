package test.chapter5.assign5_6;

import static test.util.Out.print;

public class Dog {


    public static void main(String[] args){
        Dog d = new Dog();
        d.bark(1,2L);
        d.bark(1L,2);
        d.bark(true);
        d.bark("a");
        HA.A();
    }

    public void bark(int i,long a){
        print("barking");
    }

    public void bark(String s){
        print("howling");
        this.bark(true);
        bark(true);
    }
    public void bark(boolean l){
        print("shut up");
    }
    public void bark(long l,int c){
        print("shut up long");
    }
}
