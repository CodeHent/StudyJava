package test.chapter18.iostudy;

import javafx.scene.chart.PieChart;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;

public class StoringAndRecoveringData {
    private static final String FILE = "Data.txt";

    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(FILE))
        );
        dataOutputStream.write(1000);
        dataOutputStream.writeDouble(1000.001);
        dataOutputStream.writeChar('c');
        dataOutputStream.writeChars("dasda");
        dataOutputStream.writeUTF("骂了阿达");
        dataOutputStream.close();
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(
                new FileInputStream(FILE)));
        System.out.println(dataInputStream.read());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readChar());
        System.out.println(dataInputStream.readLine());
        if (dataInputStream.available() > 0) {
//            Charset.forName(System.getProperty("file.encoding")).decode(dataInputStream.readUTF().getBytes());
            System.out.println(dataInputStream.readUTF().getBytes());
        }
        System.out.print("骂了阿达".getBytes());
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println(next);
    }
}
