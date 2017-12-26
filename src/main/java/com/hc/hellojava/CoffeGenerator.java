/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava;

import java.util.Iterator;
import java.util.Random;


/**
 *
 * @author chenghao
 */

interface Generator<T> {
    T next();
}

class Coffe {
    public static long count = 0;
    private final long id = count++;
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + id;
    }
}


class Latte extends Coffe{}

class Moca extends Coffe{}

class Capuccino extends Coffe{}

class Americano extends Coffe{}

class Breve extends Coffe{}

public class CoffeGenerator implements Generator<Coffe>, Iterable<Coffe> {
    private static Class[] types = new Class[]{Latte.class, Moca.class, Capuccino.class, Americano.class, Breve.class};
    
    private static Random rand = new Random();
    
    public CoffeGenerator(){}
    
    private int size;
    
    public CoffeGenerator(int size){
        this.size = size;
    }
        
    /**
     *
     * @return Coffe
     */
    @Override
    public Coffe next() {
        try {
            return (Coffe) types[ rand.nextInt(types.length)].newInstance();
        } catch (Exception ex) {  
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Iterator<Coffe> iterator() {
        return new CoffeIterator();
    }
    
    class CoffeIterator implements Iterator<Coffe>{
        
        int count = size;
        
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffe next() {
            count--;
            return CoffeGenerator.this.next();
        }
    
    }
    
    
    public static void main(String[] args){
        CoffeGenerator cg = new CoffeGenerator();
        for(int i=0; i < 10 ; i++){
            System.out.println( cg.next() );
        }
        
        CoffeGenerator cgs = new CoffeGenerator(10);
        
        for(Coffe cf : cgs){
            System.out.println( cf );
        }
    }
}
