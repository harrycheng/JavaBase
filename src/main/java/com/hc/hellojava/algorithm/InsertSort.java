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
public class InsertSort {
    public void sort(int[] array){
        for(int i=1; i<array.length; i++){
            int current = array[i];
            int j = i-1;
            while(j>=0 && current < array[j]){
                array[j+1] = array[j];
                j--;
            }            
            array[j+1] = current;
        }
    }    
    
    public void sort(int[] array, int left, int right){            
        for(int i = left + 1; i <= right;  i++){
            int current = array[i];
            int j = i-1;
            while(j>=left && current < array[j]){
                array[j+1] = array[j];
                j--;
            }            
            array[j+1] = current;
        }
    }

    
    public static void main(String[] args){
        int[] array = { 1, 10, 6, -1, 11, 0, 1, 10, 6, -1, 11, 0 };
        ArrayPrint.print(array);
        
        InsertSort insertSort = new InsertSort();
        insertSort.sort(array, 0, array.length -1);
        
        ArrayPrint.print(array);
    }
}

