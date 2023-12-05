package org.example.bases.algorithms.insertionsort;

public class InsertionSort {

    public static void main(String[] args) {

    }
    public static <T> T[] insertionSort(T[] array){

        for (int i = 1; i < array.length; i++) { //Begin with second character
            int j = i;
            T currentValue = array[i];          //Time to insert current value
            while(j>0 && array[j-1] > currentValue){
                array[i] = array[j-1];
                j--;
            }
            array[j] = currentValue;
        }
        return array;
    }
}
