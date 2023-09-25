package org.example.targetValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 *Given an array of integers, return indices of the two number such that they
 *  add up to a specific target.
 * you may assume that each input would have exactly one solution and you may
 *  not use the same element twice.
 *
 */
public class SolutionImplementation
{
    private static final Integer[] numbers = new Integer[]{ 2, 7, 11, 15 };
    private static final Integer TARGET_VALUE = 9;
    
    /*
     * First take an element from the array.
     * create a value from a subtraction between first element and target.
     * Use that value to find the second value to make the target.
     */
    public static void main(String[] args)
    {
        int position = 0;
        Integer firstElemet = 0;
        HashMap<Integer, Integer> matchinValues = new HashMap<>();
        matchinValues.put(position, firstElemet-TARGET_VALUE);
        for (int i = position + 1; i < numbers.length - 1; i++)
        {
            if(matchinValues.containsValue(numbers[i]))
            {
                matchinValues.replace(position, i);
            }
            
        }
        
    }
    
    private static Integer getAValueFromArray(int index)
    {
        return numbers[index];
    }
    
    private static
}
