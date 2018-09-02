package test.chapter18.iostudy.nio;

import com.sun.org.apache.bcel.internal.util.ByteSequence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static String s = "./src/main/java/test/chapter18/iostudy/MemerryReader.java";
    private static String c = "copy.out";

    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream(s).getChannel();
        FileChannel out = new FileOutputStream(c).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        while ((in.read(byteBuffer)) != -1) {
//            byteBuffer.flip();
//            out.write(byteBuffer);
//            byteBuffer.clear();
//        }
       in.transferTo(0,in.size(),out);

    }
}
