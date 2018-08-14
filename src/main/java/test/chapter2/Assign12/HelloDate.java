package test.chapter2.Assign12;
//:Object/HelloDate.java
import java.util.Date;

/**
 * The first think in java example program.
 * Display a string and today's date
 * @author Bruce Eckel
 * @author www.github.com
 * @version 4.0
 */
public class HelloDate {

    /**
     * Entry point to class & application.
     * @param args args array of string arguments
     */
    public static void main(String[] args)throws Exception{
        System.out.println("Hello ,it's:");
        System.out.println(new Date());
    }
} /* Output:(55% match)
Hello ,it's:
Sun Aug 05 10:58:52 CST 2018
*///:~