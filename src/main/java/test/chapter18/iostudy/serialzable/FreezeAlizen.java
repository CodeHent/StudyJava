package test.chapter18.iostudy.serialzable;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;

public class FreezeAlizen {
    @Override
    public String toString() {
        return "FreezeAlizen{}"+super.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("class.out"));
        Alen alen = new Alen();
        objectOutputStream.writeObject(alen);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("class.out"));
        Alen al = (Alen)objectInputStream.readObject();
        System.out.println(al);

        System.out.print(new FreezeAlizen());
    }
}

class Alen implements Serializable{

}