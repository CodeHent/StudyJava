package test.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("class name" + cc.getName());
        System.out.println("simple name" + cc.getSimpleName());
        System.out.println("Canonical name" + cc.getCanonicalName());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = null;
        try {
            c = Class.forName("test.chapter14.FancyToy");
        } catch (Exception e) {
            System.out.println("未找到类");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo((obj).getClass());
        Class<FancyToy> c1 = FancyToy.class;
        Class<? super FancyToy> cca = c1.getSuperclass();
        printInfo(cca);
        System.out.println("______________________");
        Class<?> aClass = Class.forName("test.chapter14.Toy");
        try {
            Constructor constructors = aClass.getConstructor(int.class);
            Toy o = (Toy)constructors.newInstance(1);
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        for (Constructor constructor : constructors){
//            System.out.println(constructor.toString());
//        }
    }
}

class CCc {
}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}


class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}