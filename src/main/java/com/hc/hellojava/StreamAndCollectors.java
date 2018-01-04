/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.hellojava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author pearlliu
 */

class Dish{
    public Dish(String name, boolean vegatarian, int calories, Type type) {
        this.name = name;
        this.vegatarian = vegatarian;
        this.calories = calories;
        this.type = type;
    }
    
    private final String name;

    public String getName() {
        return name;
    }

    public boolean isVegatarian() {
        return vegatarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
    private final boolean vegatarian;
    private final int calories;
    private final Type type;
    
    public enum Type { MEAT, FISH, OTHER}
}
public class StreamAndCollectors {
    public static void main(String[] args){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT), 
                new Dish("beef", false, 700, Dish.Type.MEAT), 
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.MEAT),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 300, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("pranwns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        
        
        //1.计数
        long count = menu.stream().count();
        
        //2.筛选 , 限制个数， 跳过 
        List<Dish> vegatarian = menu.stream().filter(o->o.isVegatarian()).limit(3).skip(1).collect(Collectors.toList());
    
        //3.映射
        List<String> foods = menu.stream().map(o->o.getName()).collect(Collectors.toList());
        
        //4.归约 最大值
        
        Optional<Integer> dish = menu.stream().map(o->o.getCalories()).reduce(Integer::max);
        
        //5.收集器
        Map<Dish.Type, List<Dish>> dishByType = menu.stream().collect(Collectors.groupingBy( o->o.getType()));
        
        
    
    }
}
