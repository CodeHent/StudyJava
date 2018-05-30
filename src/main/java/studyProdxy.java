import service.*;

import java.lang.reflect.Proxy;

public class studyProdxy {

    public static void main(String[] args){
        liquor li = new beer();
        liquor mao = new maotai();

        counter c = new counter(li);
        c.taste();

        liquor proxy = (liquor) Proxy.newProxyInstance(mao.getClass().getClassLoader(), new Class[]{liquor.class},new LiquorProxy(mao));
         proxy.taste();
    }


}
