import org.apache.commons.collections.CollectionUtils;
import self.service.*;

import java.lang.reflect.Proxy;
import java.util.*;

import static java.util.Collections.*;

public class studyProdxy {

    public static void main(String[] args){
        liquor li = new beer();
        liquor mao = new maotai();

        counter c = new counter(li);
        c.taste();

        liquor proxy = (liquor) Proxy.newProxyInstance(mao.getClass().getClassLoader(), new Class[]{liquor.class},new LiquorProxy(mao));
         proxy.taste();

         Map map = new LinkedHashMap();
         map.put("1","58");
        map.put("2","58");

        List<Integer> list = new ArrayList<Integer>(){{
            add(4);
            add(3);
        }};
        System.out.println(list);
        sort(list,);
        System.out.println(list);
    }

    public static void printA(){
        System.out.println("A");
    }

}
