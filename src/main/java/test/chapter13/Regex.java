package test.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.json.JSONObject;

public class Regex {
    public static void main(String[] args){
        System.out.println("-1asdas".matches("-*\\d+(\\s*)"));
        Pattern pattern = Pattern.compile("(?i)");
        System.out.println("aa"+pattern.matcher("A happy day").find());

        pattern = Pattern.compile("abc+");
        int i = pattern.matcher("abcabcabc").groupCount();
        System.out.println(i);
        System.out.println(pattern.matcher("abcabcabc").find());

        String [] s = {"abcabcabcdefabc"};
        for (String arg:s){
            System.out.println(arg);
            pattern = Pattern.compile(arg);
            Matcher matcher = pattern.matcher(s[0]);
            while (matcher.find()){
                System.out.println(matcher.group()+ " "+matcher.start()+"-"+(matcher.end()-1));
            }
        }


        int a = 1;
        int b = a==1? 2:3;
        System.out.println(b);
        JSONObject jsonObject = JSONObject.fromObject(null);
        Object a1 = jsonObject.get("a");
        System.out.println(a1);
    }
}
