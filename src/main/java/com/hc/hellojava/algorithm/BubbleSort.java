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
public class BubbleSort {
        public void sort(int[] array){
        int length = array.length;
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i - 1; j++){
                if(array[j] > array[j+1] ){
                    swap(array, j);
                }
            }
            //int current = array[i];
            
        }
    }

    private void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j+1];
        array[j+1]= temp;
    }
    
    public static void main(String[] args){
        int[] array = { 1, 10, 6, -1, 11, 0 };
        ArrayPrint.print(array);
        
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        
        ArrayPrint.print(array);
    }
}
