/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author chenghao
 */

interface Interface{
    void doSomething();
    void someThingElse(String arg);
}

class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println(" real doSomething ");
    }

    @Override
    public void someThingElse(String arg) {
        System.out.println(" real someThingElse " + arg);
    }
    
}
        
class MyInvocationHandler implements InvocationHandler{
    Object object;
    
    public MyInvocationHandler(Object o){
        object = o;
    }
    
            
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    
        System.out.println("myMethed before invoke");
        return method.invoke(object, args);
    }
    
}

public class DynamicProxy{

    public static void main(String[] args){
        Interface i;
        ClassLoader cl = Interface.class.getClassLoader();
        Class<?>[] classArray = new Class<?>[]{ Interface.class };
        MyInvocationHandler dp = new MyInvocationHandler(new RealObject());
        
        i = (Interface)Proxy.newProxyInstance(cl , classArray, dp);
        i.doSomething();
        i.someThingElse("abc");
        
        System.out.println(i.getClass().getName());

    }
}
