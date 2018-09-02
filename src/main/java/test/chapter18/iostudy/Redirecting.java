package test.chapter18.iostudy;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("./src/main/java/test/chapter18/iostudy/Redirecting.java")
        );

        PrintStream out = new PrintStream(new FileOutputStream("test.out"));

        System.setErr(out);
        System.setIn(in);
        System.setOut(out);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = bufferedReader.readLine())!= null){
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }
}
