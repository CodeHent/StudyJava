package test.chapter2;

public class Assign8 {
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
        DataOnly dataOnly1 = new DataOnly();
        incrementable.increment();
        DataOnly dataOnly2 = new DataOnly();
        System.out.println(DataOnly.i);
        System.out.println(dataOnly1.i==dataOnly2.i);
    }
}
