package test.chapter18.iostudy;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static test.chapter18.iostudy.BufferIo.*;

public class FormatMemoryInput {

    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(
                BufferIo.read("./src/main/java/test/chapter18/iostudy/MemerryReader.java").getBytes()));
        try {
            while (true) {
                System.out.print((char)dataInputStream.readByte());
            }
        } catch (Exception e) {
            System.out.print("End");
        }

        System.out.println("加入available");
        //available()函数用来检测文件读入是否到底
        while(dataInputStream.available()!= 0){
            System.out.print((char)dataInputStream.readByte());
        }
    }
}
