/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author chenghao
 */

class Apple{
    private String color;
    private int weight;

    public Apple(String color, int weight){
        this.color = color;
        this.weight = weight;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class AplleWeightCompare implements Comparator<Apple>{    
    @Override
    public int compare(Apple o1, Apple o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}

public class LambdaAndFunctionRef {
    public static void main(String[] args){
        List<Apple> inventory = Arrays.asList(new Apple("red", 10), new Apple("green", 11),new Apple("yellow", 12) );
        
        // 1新建类
        inventory.sort(new AplleWeightCompare());
        
        //2匿名类
        inventory.sort( new Comparator<Apple>(){
            @Override
            public int compare(Apple o1, Apple o2) {                
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        
        //3Lambda
        inventory.sort( (o1, o2)->{
            return Integer.compare(o1.getWeight(), o2.getWeight());
        });
        
        //4方法引用
        //4.1
        Comparator<Apple> c =  Comparator.comparing( (Apple a) -> a.getWeight());        
        inventory.sort(c);
        
        //4.2
        inventory.sort(Comparator.comparing( Apple::getWeight));
        
        //printApples(inventory, (Apple a) -> {  a.getWeight().toString() } );                
       
    }
    
    static void printApples(List<Apple> inventory, Function<Apple, String> f ){
        inventory.forEach((a) -> {
            System.out.println(f.apply(a));
        });
    }
}
