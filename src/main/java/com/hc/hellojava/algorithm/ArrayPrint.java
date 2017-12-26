/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava.algorithm;

/**
 *
 * @author chenghao
 */
public class ArrayPrint {
    public static void print(int[] array){
        for(int item : array){
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}
