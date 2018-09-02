package test.chapter18.iostudy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferIo {

    public static String s;

    public static String read(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        while((s=bufferedReader.readLine()) != null){
            sb.append(s+"\n");
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        File f = new File(".");
        System.out.println(f.getAbsolutePath());
        System.out.println(read("./src/main/java/test/chapter18/iostudy/BufferIo.java"));
    }
}
