package test.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage = "usage:\n" +
            "ShowMethods qualicfied.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name world\n" +
            "To search for methods involving 'world'";
    private static Pattern p = Pattern.compile("final|native");

    public static void main(String[] args) {
        args= new String[]{"test.chapter14.Toy"};
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> aClass = Class.forName("test.chapter14.Toy");

            System.out.println("+++++");

            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(p.matcher(method.toString()).replaceAll(" "));
                }
                System.out.println("++++");
                for (Constructor constructor : constructors) {
                    System.out.println(p.matcher(constructor.toString()).replaceAll(" "));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(" "));
                        lines++;
                    }
                }
                for (Constructor constructor : constructors) {
                    if (constructor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(constructor.toString()).replaceAll(" "));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("no such class");
            e.printStackTrace();
        }
        System.out.println("lines: "+lines);

    }
}
