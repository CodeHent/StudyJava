package test.chapter18.iostudy;

import com.sun.xml.internal.txw2.output.DataWriter;

import java.io.*;

public class BasicFileOutput {

    private static String s;
    private static String file = "temp1.out";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("./src/main/java/test/chapter18/iostudy/BufferIo.java"));
        LineNumberReader lineNumberReader = new LineNumberReader(
                new StringReader(BufferIo.read("./src/main/java/test/chapter18/iostudy/BufferIo.java")));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp.out"));

        FileWriter fileWriter = new FileWriter("temp2.out");

        PrintWriter out = new PrintWriter(file);
        int lineCount = 0;
        long l = System.currentTimeMillis();
        while ((s = bufferedReader.readLine()) != null) {
            bufferedWriter.write(lineCount++ + ":" + s);
            bufferedWriter.newLine();
//            bufferedWriter.write(lineCount++ +":"+s);
        }
        System.out.println("1:" + (System.currentTimeMillis() - l) + "ms");
        l = System.currentTimeMillis();
        while ((s = lineNumberReader.readLine()) != null) {
            fileWriter.write(lineCount + ":" + s+"\n");
        }
        System.out.println("2:" + (System.currentTimeMillis() - l) + "ms");

        while ((s = lineNumberReader.readLine()) != null) {
            out.println(lineNumberReader.getLineNumber() + ":" + s);
        }
        System.out.println(bufferedReader.toString());
        bufferedWriter.close();
        out.close();
        fileWriter.close();
        System.out.println(BufferIo.read("./src/main/java/test/chapter18/iostudy/BufferIo.java"));
    }
}
