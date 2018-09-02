package test.chapter14;

class Base {
}

class Derive extends Base {
}

public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instance of base " + (x instanceof Base));
        System.out.println("x instanceof Derive " + (x instanceof Derive));
        System.out.println("base.isInstance(x) " + Base.class.isInstance(x));
        System.out.println("Derived isInstanceOf(x) " + Derive.class.isInstance(x));
        System.out.println("x.getClass() == Base.Class " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derive.Class " + (x.getClass() == Derive.class));
        System.out.println("x.getClass().equals(Base.class) " + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derive.class) " + (x.getClass().equals(Derive.class)));
        System.out.println("+++++++++++++++++++++++++++++++++");
    }

    public static void main(String [] args){
        test(new Base());
        test(new Derive());

    }
}
