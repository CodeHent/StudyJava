package test.chapter2;

public class Assign7 {
    public static class DataOnly{
        static int i;
    }

    public static class Incrementable{
        public void increment(){
            DataOnly.i++;
        }
    }

    public static void main(String [] a){
        Incrementable incrementable = new Incrementable();
        incrementable.increment();
        System.out.println(DataOnly.i);
    }
}
