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
public class QuickSort {

    private static int cutOff = 4;
    
    private InsertSort insertSort = new InsertSort();
            
    public static void main(String[] args) {        
        int[] array = {1, 10, 6, -1, 11, 0, 1, 10, 6, -1, 11, 0};
        //int[] array = {1,0,0,1};
        ArrayPrint.print(array);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length -1);

        ArrayPrint.print(array);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sort(int[] array, int left, int right) {        
        if (left + cutOff <= right) {            
            int pivot = median3(array, left, right);            
            int i = left;
            int j= right-1;
            for (;;) {
                while (array[++i] < pivot) {
                }
                while (array[--j] > pivot) {
                }
                if (i < j) {
                    swap(array, i, j);
                } else {
                    break;
                }                
            }
            swap(array, i, right - 1);
            
            sort(array, left, i-1);
            sort(array, i+1 , right);
        } else {
            insertSort.sort(array, left, right);
        }
    }

    private int median3(int[] array, int left, int right) {
        int middle = (left + right) / 2;

        if (array[left] > array[middle]) {
            swap(array, left, middle);
        }

        if (array[left] > array[right]) {
            swap(array, left, right);
        }

        if (array[middle] > array[right]) {
            swap(array, middle, right);
        }

        swap(array, middle, right - 1);

        return array[right - 1];
    }
}
