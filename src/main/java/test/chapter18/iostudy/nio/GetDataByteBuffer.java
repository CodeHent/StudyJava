package test.chapter18.iostudy.nio;

import java.nio.ByteBuffer;

public class GetDataByteBuffer {
    private static int SIZE = 1024;
    public static void main(String[] args){
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);

        int i=0;
        while(i++<buffer.limit()){
            if(buffer.get()!=0){
                System.out.println("no zero");
            }
        }
        buffer.rewind();

        buffer.asCharBuffer().put("Howdy");
        char c ;
        while((c = buffer.getChar())!=0){
            System.out.print(c+" ");
        }
        buffer.rewind();

        buffer.asShortBuffer().put((short) 123);
        System.out.print(buffer.getShort());
    }
}
