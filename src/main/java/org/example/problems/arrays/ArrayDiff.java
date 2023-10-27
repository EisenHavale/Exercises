package org.example.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Your goal in this kata is to implement a difference function, which subtracts one list from
another and returns the result.
It should remove all values from list a, which are present in list b keeping their order.
* Goal remove all occurrences of list B in List A.
! Can't sort array A because have to keep same order
? Is there an advantage by sorting array B?
!ARRAY B IS THE LIMIT OF A POSSIBLE CYCLE
* Return a copy of the new array.
* Need: For to go over every element of array B
* While to review if the found element in B exists in A validating not going over length.
? Should I remove duplicates from Array B?

 */
public class ArrayDiff
{
    public static void main(String[] args)
    {
        diff(new int[]{1,2,3,4,5,6}, new int[]{2,3,2});
    }

    public static int[] diff(int[] arrayA, int[] arrayB)
    {
        int index = 0;
        List<Integer> testedValuesList = new ArrayList<>();

        if(arrayB.length==1){
            return solution(arrayA, arrayB[0]);
        }

        while (index < arrayB.length)
        {
            if(index == 0 || !testedValuesList.contains(arrayB[index]))
            {
                arrayA = solution(arrayA, arrayB[index]);
                testedValuesList.add(arrayB[index]);
            }
            index++;
        }
        return arrayA;
    }

    public static int[] solution(int[] array, int value)
    {
        List<Integer> finalArray = new ArrayList<>(){};
        for (final int j : array)
        {
            if (j != value)
            {
                finalArray.add(j);
            }
        }
        int[] result = new int[finalArray.size()];
        int index = 0;
        for (int number : finalArray)
        {
               result[index++] = number;
        }
        return result;
    }
}
