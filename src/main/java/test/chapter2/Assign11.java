package test.chapter2;

public class Assign11 {
    public static class AllTheColorOfTheRainbow{
        int anIntegerRepresentingColors;
        void changeTheHueOfTheColor(int newHue){
            anIntegerRepresentingColors = newHue;
        }
    }
    public static void main(String[] args){
        AllTheColorOfTheRainbow allTheColorOfTheRainbow = new AllTheColorOfTheRainbow();
        System.out.println(allTheColorOfTheRainbow.anIntegerRepresentingColors);
        allTheColorOfTheRainbow.changeTheHueOfTheColor(10);
        System.out.println(allTheColorOfTheRainbow.anIntegerRepresentingColors);
    }
}
