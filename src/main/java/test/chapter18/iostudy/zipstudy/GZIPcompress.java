package test.chapter18.iostudy.zipstudy;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("temp.out"));

        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));

        int s;
        while ((s = bf.read()) != -1) {
            out.write(s);
        }
        bf.close();
        out.close();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new GZIPInputStream(
                        new FileInputStream("test.gz")
                )
        );

        while ((s = bufferedInputStream.read()) != -1) {
            System.out.print((char) s);
        }
    }
}
