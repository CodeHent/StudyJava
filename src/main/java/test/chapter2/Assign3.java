package test.chapter2;

public class Assign3 {

    private static class ATypeName{
        int a;
        public void print(){
            System.out.println(a);
        }

    }
    public static void main(String[] a){
        ATypeName aTypeName = new ATypeName();
        aTypeName.print();
    }

}
