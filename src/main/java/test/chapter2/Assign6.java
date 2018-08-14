package test.chapter2;

public class Assign6 {
    public static class DataOnly{
        String s;

        public int storage(String s){
            return s.getBytes().length;
        }
    }

    public static void main(String [] a){
        DataOnly dataOnly = new DataOnly();
        System.out.println(dataOnly.storage("da"));
    }
}
