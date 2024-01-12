package org.example.algorithmsAndStructures.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ReinforcementExercises {
    public static void main(String[] args) {
        removeRandomValue(new Integer[] {1,2,3,4,5});
    }

    /*
        1. Create a method to randomly select and remove an entry from an array till the array holds no entries
     */

    public static <T> void removeRandomValue(T [] arrayOfEntries  ){
        Random value = new Random(arrayOfEntries.length);
        while(arrayOfEntries.length > 0){
             final int index = (arrayOfEntries.length==1) ? 0 : value.nextInt(arrayOfEntries.length-1);
             System.out.println(index);
             arrayOfEntries = reduceArray(arrayOfEntries, index);

        }
    }

    public static <T>  T[] reduceArray(T[] array, int index){
        return (T[]) Arrays.stream(array).filter(entry -> !entry.equals(array[index])).toArray();
    }
}
