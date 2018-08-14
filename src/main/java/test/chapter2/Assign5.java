package test.chapter2;

public class Assign5 {
    public static class DataOnly{
        int i;
        double d;
        boolean b;

    }
    public static void main(String[] a){
        DataOnly dataOnly = new DataOnly();
        System.out.println(dataOnly.i+" "+dataOnly.d+" "+dataOnly.b);
    }
}
