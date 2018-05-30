package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LiquorProxy implements InvocationHandler {
    Object realObject;

    public LiquorProxy(Object realObject) {
        this.realObject = realObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy!");
        return method.invoke(realObject,args);
    }
}
