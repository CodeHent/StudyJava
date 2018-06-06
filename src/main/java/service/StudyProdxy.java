package service;

import service.aop.LittleWhite;
import service.aop.jikejia;
import service.proxy.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.log4j.Logger;

public class StudyProdxy {
    private static final Logger logger = Logger.getLogger(StudyProdxy.class.getName());

    public static void main(String[] args){
        liquor li = new beer();
        liquor mao = new maotai();

        counter c = new counter(li);
        c.taste();

        System.out.println("master branch");

        liquor proxy = (liquor) Proxy.newProxyInstance(mao.getClass().getClassLoader(), new Class[]{liquor.class},new LiquorProxy(mao));
         proxy.taste();

        LittleWhite littleWhite = new LittleWhite();
        if(LittleWhite.class.isAnnotationPresent(jikejia.class)){
            jikejia j = LittleWhite.class.getAnnotation(jikejia.class);
            System.out.println(j.value());
        }

        Method[] methods = LittleWhite.class.getMethods();
        for(Method m :methods){
            if(m.isAnnotationPresent(jikejia.class)){
                m.setAccessible(true);
                try {
                    m.invoke(littleWhite,null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        Integer a = null;
        System.out.println(String.format("aaa%s",a));
        logger.info("asdasdasljdlasj;dl++++++++++++++++++++++++++++");
        logger.error("dasdasdjas+++++++++++++++++++++++++++++++++");
    }
}
