package test.chapter18.iostudy.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 多线程访问，对文件加锁保证有序访问
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileChannel fileChannel = new FileOutputStream("copy.out").getChannel();

        FileLock fileLock = fileChannel.tryLock();
        if(fileLock != null){
            System.out.print("Locked");
            TimeUnit.MILLISECONDS.sleep(10000);
            fileLock.release();
            System.out.print("release");
        }
        fileChannel.close();
    }
}
