/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava;

/**
 *
 * @author chenghao
 */
public class ReflectTest {

    static final int finalId = 5;
    
    static int id = 10;

    static final int randomId = Varargs.random.nextInt();
    
    static {
        System.out.println("Static Construct");
    }
    
    public ReflectTest(){
        System.out.println("Construct");
    }
}
