package test.chapter18.iostudy;

import java.io.IOException;
import java.io.StringReader;

public class MemerryReader {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferIo.read("./src/main/java/test/chapter18/iostudy/MemerryReader.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
