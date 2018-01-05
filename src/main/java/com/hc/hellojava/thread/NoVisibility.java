/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava.thread;

/**
 *
 * @author chenghao
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    
    private static class ReadyThread extends Thread{
        @Override
        public void run(){
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    
    public static void main(String[] args){
        new ReadyThread().start();
        number = 42;
        ready = true;
    }
}
